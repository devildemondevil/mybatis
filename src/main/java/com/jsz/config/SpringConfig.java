package com.jsz.config;


import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com")
@Import({MybatisConfig.class,JDBCConfig.class})
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
}
