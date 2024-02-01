package com.example.lanshan.controller;


import com.example.lanshan.pojo.Person;
import com.example.lanshan.pojo.Result;
import com.example.lanshan.pojo.User;
import com.example.lanshan.service.UserService;
import com.example.lanshan.utils.JwtUtils;
import com.example.lanshan.utils.MD5Utils;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    //    注册
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User u = userService.findByUserName(username);
        if (u == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名重复");
        }
    }

//    登录
@PostMapping("/login")
public Result<String> login (@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp="^\\S{5,16}$") String password){
    User loginUser = userService.findByUserName(username);
    if (loginUser==null){
        return Result.error("用户名错误");
    }
    if(MD5Utils.md5(password).equals(loginUser.getPassword())) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",loginUser.getId());
        claims.put("username",loginUser.getUsername());
        String token = JwtUtils.genToken(claims);
//            储存token到redis
//            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
//            operations.set(token,token,1, TimeUnit.HOURS);
        return Result.success(token);
    }
    return Result.error("密码错误");
}
@GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token){
    Map<String ,Object> map = JwtUtils.paresToken(token);
    String username = (String) map.get("username");
    User user = userService.findByUserName(username);
    return Result.success(user);
}
    @GetMapping("/person")
    public Result<Person> personResult(@RequestHeader(name = "Authorization") String token){
        Map<String ,Object> map = JwtUtils.paresToken(token);
        String username = (String) map.get("username");
        Person person= userService.findPerson(username);
        return Result.success(person);
    }
    @PatchMapping("updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

}
