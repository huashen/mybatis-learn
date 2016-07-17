package com.lhs.mybatis.mapper;

import com.lhs.mybatis.bean.User;
import com.lhs.mybatis.bean.UserQueryVO;

import java.util.List;

/**
 * UserMapper
 *
 * @author longhuashen
 * @since 16/7/17
 */
public interface UserMapper {

    User findUserById(int id);

    List<User> findUsers(UserQueryVO userQueryVO);
}
