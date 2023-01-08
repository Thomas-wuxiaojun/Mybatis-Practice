package org.example.mapper;

import org.example.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
