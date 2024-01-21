package com.jsz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class JDBCConfig {

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
//        DriverManagerDataSource druidDataSource=new DriverManagerDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource){

        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();

        dataSourceTransactionManager.setDataSource(dataSource);

        return dataSourceTransactionManager;

    }

}
