package com.atguigu.cloud.controller;

public class test02 {

    public static void main(String[] args) {
        Father father = new Son();
        System.out.println("father.x " + father.x);
    }
}

class Father{
    int x=10;

    public Father() {
        this.print(); // 调用实例的print
        x=20;
    }

    public void print(){
        System.out.println("Father.x:" + x);
    }
}


class Son extends Father{

    int x= 30;
    public Son() { //加载父类的构造器
        this.print();
        x= 40;
    }
    public void  print(){
        System.out.println("Son.x:" + x); //先初始化为0
    }
}
