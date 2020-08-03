package com.atguigu.linkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
//穿件一个环形的单向链表
class CircleSingleLinkedList{
    //先创建一个first 没有编号
    private Boy first = new Boy(-1);
    public void addBoy(int nums){
      //做数据校验
        if(nums < 1){
            System.out.println("nums的数值应大于等于1的整数");
            return;
        }
        Boy curBoy = null;
        //使用for循环创建我们的链表
        for (int i = 1; i <= nums; i++) {
          //根据编号 创建节点
          Boy boy = new Boy(i);
          //如果是第一个小号
            if(i == 1){
                first = boy;
                first.setNext(first);//构成一个环
                curBoy = first;//first不能动
            }else {
                 curBoy.setNext(boy);//指向了下一个
                 boy.setNext(first);
                 curBoy = boy;
            }
        }
    }
    //遍历一下
    public void show(){
        if(first == null){
            System.out.println("链表为空！");
            return;
        }
        //因为first不能动 因此需要一个而辅助指针帮助
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext() == first){//已经遍历完了
                break;
            }
            curBoy = curBoy.getNext();//指针后移
        }
    }
    //根据用户的输入，计算出出圈的顺序

    /**
     *
     * @param startNo 从那个开始
     * @param countNum 数几下
     * @param nums 一共有几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums){
       //校验数据
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误！");
            return;
        }
        //需要一个变量 事先该指向环形聊表的最后这个节点
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){//只剩一个了
                break;
            }
            helper = helper.getNext();
        }
        //报数 先移动first和helper移动k-1
        for (int j = 0; j < startNo-1 ; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //开始报数  m-1
        while (true){
            if(helper == first){
                break;
            }
            //同时移动countNum - 1
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的小孩编号"+first.getNo());
    }
}
// 创建一个节点
class Boy{
    private int no;//编号
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}