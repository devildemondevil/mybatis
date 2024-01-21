package com.jsz.mapper;

import com.jsz.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserMapper {

    List<User> selectAll();
}
