package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void selectAll() throws IOException {
        //1.加载mybatis核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对行
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql  mapper代理方式
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void selectById() throws IOException {
        //1.加载mybatis核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对行
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql  mapper代理方式
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int id = 1;
        Brand brand = mapper.selectById(id);

        System.out.println(brand);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByCondition() throws IOException {
        //1.加载mybatis核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对行
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql  mapper代理方式
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int status = 0;
        String companyName = "小米";
        String brandName = "小米";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        brand.setStatus(status);
        List<Brand> brands = mapper.selectByCondition(brand);
        System.out.println(brands);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConditionSingle() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int status = 0;
        Brand brand = new Brand();

        brand.setStatus(status);

        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);

        sqlSession.close();
    }

    @Test
    public void add() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setCompanyName("aa");
        brand.setBrandName("vv");
        brand.setDescription("to be number one");
        brand.setOrdered(1);
        brand.setStatus(0);
        mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        sqlSession.close();
    }

    @Test
    public void update() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand b = new Brand();
        b.setId(6);
        b.setOrdered(1000);
        mapper.update(b);
        sqlSession.close();
    }

    @Test
    public void delete() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.deleteById(6);
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int [] ids= {4,5};
        int i = mapper.deleteByIds(ids);
        System.out.println(i);

        sqlSession.close();
    }
}
