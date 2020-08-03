package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
     //测试数组模拟环形队列  队列有效空间3个
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' ';//
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.println("环形队列");
        while (loop){
            System.out.println("s(show): 显示数据");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头部数据");
            key = scanner.next().charAt(0);
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
                        int res = queue.headQueue();
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
class CircleArrayQueue{
    private int font;
    private int rear;
    private int maxSize;
    private int[] arr;
    public CircleArrayQueue(int maxArrSize){
        maxSize = maxArrSize;
        font = 0;
        rear = 0;
        arr = new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == font;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return font == rear;
    }
    //往队列里添加数值
    public void addQueue(int value){
       //判断队列是否已满
       if(isFull()){
           System.out.println("队列已满！");
           return;
       }
       //直接将数据加入 rear本来就指向后一个元素
        arr[rear] = value;
       //将rear后移 这里必须考虑取模
        rear = (rear+1)%maxSize;
    }
    //取数据
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //这 里不做提示 ，抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //在这里需要分析出font是指向队列的第一个元素
        //1、先把font对应的值保存到临时变量中
        //2、将font后移，考虑取模
        //3、将临时保存的变量返回
        int value = arr[font];
        font =  (font + 1) % maxSize;
        return value;
    }
    //显示数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据！");
            return;
        }
        //从font开始遍历
        for(int i=font;i<font +size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //队列中数据的个数
    public int size(){
        return (rear + maxSize -font) % maxSize;
    }
    //显示头元素
    public int headQueue(){
        if(isEmpty()){
          throw new RuntimeException("队列为空！");
        }
        return arr[font];
    }
}

