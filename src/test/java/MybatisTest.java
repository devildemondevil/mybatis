import com.jsz.config.SpringConfig;
import com.jsz.mapper.BrandMapper;
import com.jsz.pojo.Brand;
import com.jsz.service.MyServiceImpl;
import com.jsz.service.MyService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MybatisTest {

    @Test
    public void selectAllTest() throws IOException {

        String resource = "mybatis-config.xml.back";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        BrandMapper mapper = session.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();

        brands.forEach((brand)->{

            System.out.println(brand.toString());

        });


        session.close();
    }

    @Test
    public void selectByIdTest() throws IOException {

        String resource = "mybatis-config.xml.back";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        BrandMapper mapper = session.getMapper(BrandMapper.class);

//        List<Brand> brands = mapper.selectAll();
        Brand brand=mapper.selectByid(1);

        System.out.println(brand.toString());
//        brands.forEach((brand)->{
//
//            System.out.println(brand.toString());
//
//        });


        session.close();
    }

    @Test
    public void addTest() throws IOException {

        SqlSession session = null;
        try {
            String resource = "mybatis-config.xml.back";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            session = sqlSessionFactory.openSession();

            BrandMapper mapper = session.getMapper(BrandMapper.class);

            Brand brand = new Brand();
            brand.setCount(12);
            brand.setName("ssm框架精讲");
            brand.setPublish("清华出版社");
            brand.setPrice(200);
//            int a= 1/0;
            mapper.add(brand);
            System.out.println(brand.getId());
            session.commit();


        } catch (Exception e) {
            assert session != null;
            session.rollback();

        } finally {
            assert session != null;
            session.close();
        }

    }

    @Test
    public void testSpring(){

        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);

        BrandMapper brandMapper=applicationContext.getBean(BrandMapper.class);

//        Brand brand = new Brand();
//        brand.setCount(12);
//        brand.setName("ssm框架精讲");
//        brand.setPublish("清华出版社");
//        brand.setPrice(200);

//        brandMapper.add(brand);

//        List<Brand> brands = brandMapper.selectAll();
//
//        brands.forEach(brand -> {
//            System.out.println(brand.toString());
//        });

//        System.out.println(brands);

        MyService myService=applicationContext.getBean(MyServiceImpl.class);
        myService.transfer();


    }
}
