package com.lhs.test;

import com.lhs.mybatis.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * MybatisTest
 *
 * @author longhuashen
 * @since 16/7/13
 */
public class MybatisTest {

    @Test
    public void testFindUserById() throws IOException {

        String resources = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testFindUserByName() throws IOException {

        String resources = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("test.findUserByName", "long");

        System.out.println(userList);

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testAddUser() throws IOException {

        String resources = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("李四");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("广州市");

        sqlSession.insert("test.addUser", user);

        sqlSession.commit();

        System.out.println(user.getId());

        //释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() throws IOException {

        String resources = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        sqlSession.delete("test.deleteUser", 6);

        sqlSession.commit();


        //释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() throws IOException {

        String resources = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resources);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("李四");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("广州市");

        sqlSession.update("test.updateUser", user);

        sqlSession.commit();


        //释放资源
        sqlSession.close();
    }
}
