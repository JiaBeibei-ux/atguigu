package com.atguigu.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
     //进行测试
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.list();
    }
}
//定义一个SingleLinkedList 管理我们的英雄
class SingleLinkedList{
    //初始化头结点 一般不要动 不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");
    //添加节点到单向链表
      //不考虑编号顺序时
       //找到最后的一个节点
        //将最后的这个节点的next 指向新的节点
    public void add(HeroNode heroNode){
      //因为head不能动 再次需要一个辅助指针
       HeroNode temp = head ;
       //遍历链表，找到最后
        while (true){
            //找到最后
            if(temp.next == null){
                break;
            }
            //没有没有找到 将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向最后
        temp.next = heroNode;//将最后这个节点指向新的节点
    }
    //显示链表
    public void list(){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //因为头结点，不能动，因此我们需要一个辅助变量
        HeroNode temp  = head.next;
        while(true){
           //判断链表是否到达了最后
           if(temp == null){
               break;
           }
           //输出节点的信息
            System.out.println(temp);
           //将temp后移
            temp = temp.next;
        }
    }
}
//先定义HeroNode,每个heroNode对象就是每一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode(int no,String name,String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为例显示方法 我们重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}