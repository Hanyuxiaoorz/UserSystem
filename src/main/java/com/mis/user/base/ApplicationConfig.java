package com.mis.user.base;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

/*
* this is a class about importing the configuration
* @author:Dengsiyuan
* */
@Import({DruidDataSourceConfig.class, MybatisConfig.class})
@Configurable
public class ApplicationConfig {
}
