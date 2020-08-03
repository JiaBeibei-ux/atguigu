package com.atguigu.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        //容器启动
        context.start();
        //等待录入 按任意键退出
        System.in.read();
    }
}
