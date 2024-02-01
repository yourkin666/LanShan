package com.example.lanshan.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userPic;//用户头像
    private LocalDateTime creatTime;
    private LocalDateTime updateTime;
}
