package com.atguigu.queue;


import java.util.Scanner;

/**
 * 使用数组模拟队列
 */
public class ArrayQueueDemo{
public static void main(String[]args){
    ArrayQueue queue = new ArrayQueue(3);
    char key = ' ';//接受用户输入
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    while(loop){
        System.out.println("s(show): 显示数据");
        System.out.println("e(exit): 退出程序");
        System.out.println("a(add): 添加数据到队列");
        System.out.println("g(get): 从队列取出数据");
        System.out.println("h(head): 查看队列头部数据");
        key = scanner.next().charAt(0);//接收一个字符
        switch (key){
            case 's':
                queue.showQueue();
                break;
            case 'a':
                System.out.println("输入一个数");
                int value = scanner.nextInt();
                queue.addQueue(value);
                break;
            case 'g':
                try {
                    int res = queue.getQueue();
                    System.out.printf("取出的数据为%d\n",res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 'h':
                try {
                    int res = queue.headQueue();
                    System.out.printf("取出的数据为%d\n",res);
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
    System.out.println("程序退出");
  }
}
//使用数组模拟队列
class ArrayQueue {
     private int maxSize;//表示数组的最大容量 即队列的最大容量
     private int font;//队列头
     private int rear;//队列尾
     private int[] arr;//该数组用于存放数据,模拟队列

     //创建队列的构造器
     public ArrayQueue(int arrMaxSize) {
         maxSize = arrMaxSize;
         arr = new int[maxSize];
         font = -1;//指向队列头部，分析出font是指向队列头前一个位置
         rear = -1;//指向队列尾部，就是队列的最后一个数据
     }

     //判断队列是否满
     public boolean isFull() {
         return rear == maxSize - 1;
     }

     //判断队列是否为空
     public boolean isEmpty() {
         return rear == font;
     }

     //添加数据到队列
     public void addQueue(int n) {
         //判断队列是否满
         if (isFull()) {
             System.out.println("队列已满，不能再加入");
             return;
         }
         rear++;
         arr[rear] = n;
     }

     //出队列
     public int getQueue() {
         //判断队列是否为空
         if (isEmpty()) {
             //通过抛异常提示
             throw new RuntimeException("队列已空，不能去数据");
         }
         font++;//font后移
         return arr[font];
     }

     //显示队列的数据
     public void showQueue() {
         //遍历
         if (isEmpty()) {
             System.out.println("队列为空，没有数据");
             return;
         }
         for (int i = 0; i < arr.length; i++) {
             System.out.printf("arr[%d]=%d\n", i, arr[i]);
         }
     }

     //显示头数据，注意不是取数据
     public int headQueue() {
         //判断队列是否为空
         if (isEmpty()) {
             //通过抛异常提示
             throw new RuntimeException("队列已空，不能去数据");
         }
         return arr[font + 1];
     }
}



