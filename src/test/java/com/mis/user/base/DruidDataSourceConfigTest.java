package com.mis.user.base;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DruidDataSourceConfigTest {
    @Test
    public void testGenerateDruidDataSourceConfig() throws Exception{
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DruidDataSourceConfig.class);
        DruidDataSource druidDataSource = (DruidDataSource) applicationContext.getBean("dataSource");
        Assert.assertNotNull(druidDataSource);
    }
}