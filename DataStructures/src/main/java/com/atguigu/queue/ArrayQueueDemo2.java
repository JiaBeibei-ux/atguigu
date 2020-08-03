package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo2 {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示数据");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头部数据");
            key = scanner.next().charAt(0);//取出输入的第一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数字");
                        int value = scanner.nextInt();
                        queue.addQueue(value);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.getHead();
                        System.out.println("头元素为"+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}
class QueueArray{
    //队列基本信息
    private int font;
    private int rear;
    private int maxSize;
    private int[] arr;
    public QueueArray(int maxQueueSize){
        maxSize=maxQueueSize;
        arr = new int[maxSize];
        font = -1;
        rear = -1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == font;
    }
    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize-1;
    }
    //添加元素
    public void addQueue(int value){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满！,重新选择");
            return;
        }
        //尾指针后移
        rear++;
        arr[rear] = value;
    }
    //取出元素
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //这里不做提示 抛异常
            throw new RuntimeException("队列为空");
        }
        //头指针后移
        font++;
        return arr[font];
    }
    //显示数据
    public void showQueue(){
        //判断是否为空
        if(isEmpty()){
            //这里不做提示 抛异常
            System.out.println("队列为空");
            return;
        }
        for (int i=0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示头元素
    public int getHead(){
        //判断是否为空
        if(isEmpty()){
            //这里不做提示 抛异常
            throw new RuntimeException("队列为空");
        }
        return arr[font+1];
    }
}
