package com.jsz.mapper;

import com.jsz.pojo.Brand;
import com.jsz.pojo.User;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectByid(int idd);

    void add(Brand brand);

    void update(Brand brand);


}
