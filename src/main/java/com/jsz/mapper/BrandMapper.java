package com.jsz.mapper;

import com.jsz.pojo.Brand;
import com.jsz.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectByid(int idd);

    void add(Brand brand);

    void update(Brand brand);


}
