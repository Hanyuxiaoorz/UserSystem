package com.mis.user.backstagemanagement.service.iml;

import com.mis.user.backstagemanagement.service.ExcelInputService;
import com.mis.user.backstagemanagement.service.UserPermissionService;
import com.mis.user.regist.dao.UserRegistMapper;
import com.mis.user.regist.model.UserRegistInfo;
import com.mis.user.util.ExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelInputServiceIml implements ExcelInputService {

    private static final Logger logger = LoggerFactory.getLogger(ExcelInputServiceIml.class);
    @Autowired
    UserRegistMapper userRegistMapper;
    @Value("${file.path}")
    private String filePath;
    private String log1,log2,log3,log4;

    /**
     * @Param: fileName,mfile,session
     *
     * */
    @Override
    public String batchImport(String fileName, MultipartFile mfile, HttpSession session) {
        String result = null;
        try {
            if (session.getAttribute("user") != null) {
                log1 =(String) session.getAttribute("user") + "使用";
                File uploadDir = new File(filePath + session.getAttribute("user"));
                //判断是否存在，不存在即创建
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                File tempFile = new File(filePath + session.getAttribute("user") + File.separator + new Date().getTime() + ".xlsx");
                //初始化输入流
                InputStream is = null;
                try {
                    //将上传的文件写入新的文件中
                    mfile.transferTo(tempFile);
                    //根据新建的文件实例化输入法
                    is = new FileInputStream(tempFile);
                    //根据版本选择创建Workbook的方式
                    Workbook wb = null;
                    //判断是2003还是2007
                    if (ExcelUtil.isExcel2003(fileName)) {
                        log1 += "2003版";
                        wb = new XSSFWorkbook(is);
                    } else if (ExcelUtil.isExcel2007(fileName)) {
                        log1 += "2007版";
                        wb = new XSSFWorkbook(is);
                    } else {
                        result = "文件类型不符合要求，请重新选择";//不符合要求的文件类型
                    }
                    log1 += "申请导入：";
                    result = readExcel(wb,tempFile);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            is = null;
                            e.printStackTrace();
                        }
                    }
                }
            }else {
                result = "未登录，请登陆后进行操作";//3，未登录，无权限
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return result;
    }

    @Override
    public String readExcel(Workbook wb, File tempFile){

        //错误信息接收器
        String errorMsg = "";
        //得到第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //得到sheet中的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        //总列数
        int totalCells = 0;
        //得到sheet的列数,从第2行起
        if(totalRows >= 2 && sheet.getRow(1) != null){
            totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
            log2 = "共有" + totalRows + "行" + totalCells + "列";
        }
        List<UserRegistInfo> userRegistInfoList = new ArrayList<UserRegistInfo>();
        UserRegistInfo userRegistInfo;
        //循环excel行数，从第二行开始（标题不入库）
        for (int r = 1;r <totalRows; r++){
            String rowMessage = "";
            Row row = sheet.getRow(r);
            if(row == null){
                errorMsg += "第"+(r+1)+"行数据有问题，请仔细检查！";
                continue;
            }
            userRegistInfo = new UserRegistInfo();

            String userName = "";
            String e_mail = "";
            long id = 0;
            String study_direction = "";

            //循环Excel的列
            for(int c = 0; c <totalCells; c++){
                Cell cell = row.getCell(c);
                if (null != cell){
                    userRegistInfo.setPassword("111111");
                    if(c == 0){
                        userName = cell.getStringCellValue();
                        if(StringUtils.isEmpty(userName)){
                            rowMessage += "用户名不能为空；";
                        }else if(userName.length()>50){
                            rowMessage += "用户名的字数不能超过50；";
                        }else {
                            userRegistInfo.setUserName(userName);
                        }
                    }else if(c == 1){
                        e_mail = cell.getStringCellValue();
                        if(StringUtils.isEmpty(e_mail)){
                            rowMessage += "用户e-mail不能为空；";
                        }else if(userRegistMapper.registUserByUserEmail(e_mail) != null){
                            rowMessage += "邮箱为"+e_mail+"的用户已存在";
                        }else if(e_mail.length()>50){
                            rowMessage += "用户e-mail的字数不能超过50；";
                        }else {
                            userRegistInfo.setE_mail(e_mail);
                        }
                    }else if(c == 2){
                        id = (long) cell.getNumericCellValue();
                        String userId = String.valueOf(id);
                        if(userId.length() == 0){
                            rowMessage += "用户id不能为空；";
                        }else if (userRegistMapper.registUserByUserId(userId) != null){
                            rowMessage += "学号为"+userId+"的用户已存在";
                        }
                        else if(userId.length() > 10){
                            rowMessage += "用户id的字数不能超过10；";
                        }else {
                            userRegistInfo.setId(userId);
                        }
                    }
                    else if(c == 3){
                        study_direction = cell.getStringCellValue();
                        if(StringUtils.isEmpty(study_direction)){
                            rowMessage += "用户学习方向不能为空；";
                        }else {
                            userRegistInfo.setStudy_direction(study_direction);
                        }
                    }
                }else{
                    rowMessage += "第"+(c+1)+"列数据有问题，请仔细检查；";
                }
            }
            //拼接每行的错误提示
            if(!StringUtils.isEmpty(rowMessage)){
                errorMsg += "\n第"+(r+1)+"行，"+rowMessage;
                log4 = "导入失败";
            }else{
                userRegistInfoList.add(userRegistInfo);
            }
        }

        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }

        log3 = "开始导入";
        //全部验证通过才导入到数据库
        if(StringUtils.isEmpty(errorMsg)){
            String result = null;
            for(UserRegistInfo userRegistInfo1 : userRegistInfoList){
                if(userRegistMapper.insertUser(userRegistInfo1) == -1){
                    result = "请更改后重新导入";
                }
                else {
                    log4 = "导入成功";
                    result = "导入成功";
                }
            }
            errorMsg += result;
        }
        logger.info(log1);
        logger.info(log2);
        logger.info(log3);
        logger.info(log4);
        return errorMsg;
    }
}
