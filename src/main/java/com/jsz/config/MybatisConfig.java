package com.jsz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setTypeAliasesPackage("com.jsz.pojo");
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.jsz.mapper");
        return mapperScannerConfigurer;

    }
}
