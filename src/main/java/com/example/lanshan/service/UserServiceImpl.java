package com.example.lanshan.service;

import com.example.lanshan.mapper.UserMapper;
import com.example.lanshan.pojo.Person;
import com.example.lanshan.pojo.User;
import com.example.lanshan.utils.MD5Utils;
import com.example.lanshan.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }
    @Override
    public void register(String username, String password) {
//加密，防止内鬼
        String md5String = MD5Utils.md5(password);
//       在进行添加
        userMapper.add(username,md5String);
    }

    @Override
    public Person findPerson(String username) {
        Person person= userMapper.findPerson(username);
        return person;
    }
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtils.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

}
