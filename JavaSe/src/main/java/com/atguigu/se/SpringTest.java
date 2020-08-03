package com.atguigu.se;

public class SpringTest {
    public static void main(String[] args) {
        String str = "Java,Java,Hello,World!";
        String newStr = str.replaceAll("Java","尚硅谷~");
        System.out.println("newStr="+newStr);
    }
}
