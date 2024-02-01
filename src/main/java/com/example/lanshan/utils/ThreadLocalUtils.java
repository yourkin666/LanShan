package com.example.lanshan.utils;

public class ThreadLocalUtils {
//    提供threadlocal对象
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();
//    根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
//    储存键值对
    public static void set(Object value){ THREAD_LOCAL.set(value);}
//  清除threadlocal
    public static void remove(){ THREAD_LOCAL.remove();}
}
