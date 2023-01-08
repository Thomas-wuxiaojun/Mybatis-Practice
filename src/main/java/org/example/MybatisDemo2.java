package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;
import org.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/*
* mybatis 代理开发
* */
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件，获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对行
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /*//3.执行sql,直接找的是Mapper文件
        List<User > users = sqlSession.selectList("test.selectAll");
*/
        //3.获取userMapper代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);

        //4.释放资源
        sqlSession.close();
    }
}
