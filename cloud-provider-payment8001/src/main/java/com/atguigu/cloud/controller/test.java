package com.atguigu.cloud.controller;

public class test {
    public static void main(String[] args) {
        String str1=new String("hello") + new String("world");
        String str2="helloworld";
        str1.intern();
        System.out.println(str1 == str2); //false
    }
}
