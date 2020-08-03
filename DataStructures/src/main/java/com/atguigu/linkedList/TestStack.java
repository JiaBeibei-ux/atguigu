package com.atguigu.linkedList;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("3");
        stack.add("2");
        stack.add("1");
        for (String s : stack) {
            System.out.print(s+" ");
        }
    }
}
