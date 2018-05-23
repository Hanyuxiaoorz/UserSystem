package com.mis.user.base;

import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MybatisConfigTest {

    @Test
    public void getSqlSessionFactoryBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DefaultSqlSessionFactory factoryBean = (DefaultSqlSessionFactory) applicationContext.getBean("sqlSessionFactoryBean");
        Assert.assertNotNull(factoryBean);
    }

    @Test
    public void getSqlSesionFactory() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Assert.assertNotNull(
                applicationContext.getBean("mapperScannerConfigurer")
        );
    }
}