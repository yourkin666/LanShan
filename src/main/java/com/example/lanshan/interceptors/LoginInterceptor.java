package com.example.lanshan.interceptors;

import com.example.lanshan.utils.JwtUtils;
import com.example.lanshan.utils.ThreadLocalUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        令牌验证
        String token = request.getHeader("Authorization");
//        验证token
        try {
//       从redis中获取token
//            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
//            String s = operations.get(token);
//            if (s==null){
//                throw new RuntimeException();
//           }
            Map<String,Object> claims = JwtUtils.paresToken(token);
            ThreadLocalUtils.set(claims);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtils.remove();
    }
}
