package com.jsz.service;

import com.jsz.mapper.BrandMapper;
import com.jsz.pojo.Brand;
import com.jsz.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private BrandMapper mapper;

    @Override
    public void transfer() {
        Brand brand = new Brand();
        brand.setCount(12);
        brand.setName("ssm框架精讲");
        brand.setPublish("清华出版社");
        brand.setPrice(200);

        System.out.println(mapper);

//        mapper.add(brand);
//        mapper.add(brand);

    }
}
