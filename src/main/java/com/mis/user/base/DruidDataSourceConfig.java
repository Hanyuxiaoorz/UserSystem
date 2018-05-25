package com.mis.user.base;

import com.alibaba.druid.pool.DruidDataSource;
import com.mis.user.base.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;


/*
 * This is configuration about DruidDataSources & connection DataBase
 * Use the @ImportResource to find the properities which we defined in xml file
 *
 * @author Dengsiyuan
 *
 * */
@Configurable
public class DruidDataSourceConfig extends DatabaseProperties {


    /*
    * set the first connection value,the least amout of the free and the most amout of connection
    * */
    private final int initialsize = 3;
    private final int maxActive = 30;
    private final int minIdle = 3;

    /*
    * the longest time to wait for connecting from Database
    * break the unusual connection if can`t return overtime
    * */
    private final int maxWait = 5000;
    private final boolean removeAbandoned = true;

    /*
    *if more than 180 seconds ,it can be breaked
    * */
    private final int removeAbandonedTimeout = 180;

    /*
    * if more than 180 seconds it an do a effective connection inspection
    * after connecting the connection pool as soon as do a examine
    * after return ..
    * */
    private final boolean testWhileIdle = true;
    private final boolean testOnBorrow = false;
    private final boolean testOnReturn = false;
    private final String validationQuery = "SELECT *";
    private final int validationQueryTimeout = 2;
    /*
    * T = 10 move the useless free connection which in the pool
    * the free time is 30
    * */
    private final int timeBetweenEvictionRunsMillis = 10000;
    private final int minEvictableIdleTimeMillis = 30000;
    /*
    * whether cache prepareStatement,MySql should be close
    * */
    private final boolean poolPrepareStatement = false;
    private final int maxOpenPreparedStatements = -1;
    private final int maxPoolPrepareStatementPerConnectionSize = 20;
    /**
     * config the filter which are used to Performance Monitoring & Statistics
     */
    private final String filters = "stat";
    /*
    * set whether submit by itself
    * */
    private final boolean defaultAutoCommit = true;

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setPoolPreparedStatements(poolPrepareStatement);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTimeBetweenConnectErrorMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setInitialSize(initialsize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPrepareStatementPerConnectionSize);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setValidationQueryTimeout(validationQueryTimeout);
        druidDataSource.setRemoveAbandoned(removeAbandoned);
        druidDataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        druidDataSource.setDefaultAutoCommit(defaultAutoCommit);
        try {
            druidDataSource.setFilters(filters);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return druidDataSource;
    }
}

