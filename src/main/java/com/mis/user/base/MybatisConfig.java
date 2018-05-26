package com.mis.user.base;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* This is configuration about Mybatis &Spring-Mybatis
* like sring-mybatis.xml where exsit in SSM
* sqlSessionFactoryBean is Druid`s configuration & classpath:mappers.xml
* mapperScannerConfigurer is autoScanner where mappers.java exist
*
* @author Dengsiyuan
* */

@Configurable
public class MybatisConfig {

    private final String mapperPath = "/mappers/";

    @Bean(name = "sqlSessionFactoryBean")
    @Autowired
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DruidDataSource druidDataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        Resource resource = new ClassPathResource(mapperPath);
        try{
            File file = resource.getFile();
            List<Resource> resources = new ArrayList<>();
            File[] paths = file.listFiles();
            for(int i = 0;i < paths.length;i++){
                resources.add(new PathResource(paths[i].getPath()));
            }
            Resource[] realResources = new Resource[paths.length];
            resources.toArray(realResources);
            sqlSessionFactoryBean.setMapperLocations(realResources);
        }catch (IOException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.mis.user.*.dao");
        return configurer;
    }
}
