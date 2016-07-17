package com.lhs.test;

import com.lhs.mybatis.bean.User;
import com.lhs.mybatis.bean.UserQueryVO;
import com.lhs.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MybatisTest
 *
 * @author longhuashen
 * @since 16/7/13
 */
public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void startUp() throws IOException {
        String resources = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resources);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);

System.out.println(user);
    }

    @Test
    public void testFindUserByIds() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        ids.add(16);
        UserQueryVO userQueryVO = new UserQueryVO();
        userQueryVO.setIds(ids);

        List<User> userList = userMapper.findUsers(userQueryVO);
System.out.println(userList.size());
    }
}
