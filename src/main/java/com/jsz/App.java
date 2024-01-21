package com.jsz;

import com.jsz.mapper.UserMapper;
import com.jsz.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml.back";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        List<User> users =  sqlSessionFactory.openSession().selectList("UserMapper.selectAll");

        SqlSession session=sqlSessionFactory.openSession();
        UserMapper userMapper= session.getMapper(UserMapper.class);
        List<User> users= userMapper.selectAll();
        for(User user:users){

            System.out.println(user.getId());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());

        }
        session.close();
    }


}
