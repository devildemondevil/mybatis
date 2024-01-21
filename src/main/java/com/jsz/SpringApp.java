package com.jsz;

import com.jsz.config.SpringConfig;
import com.jsz.service.MyServiceImpl;
import com.jsz.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        MyService myService=(MyService) applicationContext.getBean(MyServiceImpl.class);
        myService.transfer();
    }

}
