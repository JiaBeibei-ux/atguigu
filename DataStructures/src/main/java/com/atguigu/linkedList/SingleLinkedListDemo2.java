package com.atguigu.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo2 {
    public static void main(String[] args) {
        //进行测试
        HeroNode2 heroNode1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3,"吴用","智多星");
         HeroNode2 heroNode4 = new HeroNode2(4,"林冲","豹子头");
        SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
        /*singleLinkedList2.add(heroNode1);
        singleLinkedList2.add(heroNode3);
        singleLinkedList2.add(heroNode2);*/
        singleLinkedList2.addByOrder(heroNode1);
        singleLinkedList2.addByOrder(heroNode3);
        singleLinkedList2.addByOrder(heroNode2);
        singleLinkedList2.addByOrder(heroNode4);
        singleLinkedList2.show();
        System.out.println("====================");
        /*reversetList(singleLinkedList2.getHead());
        singleLinkedList2.show();*/
        //测试修改节点
       /* HeroNode2 newHeroNode = new HeroNode2(2,"小卢","玉麒麟~~");
        singleLinkedList2.update(newHeroNode);
        singleLinkedList2.show();
        singleLinkedList2.delete(4);
        singleLinkedList2.show();*/
        //求单链表的有效数据的个数
       /* System.out.println("有效的链表个数："+getLength(singleLinkedList2.getHead()));
        HeroNode2 res = findLastIndexNode(singleLinkedList2.getHead(), 1);
        System.out.println(res);*/
        System.out.println("逆序打印 ");
        reversePrint(singleLinkedList2.getHead());
    }
    //方法： 获取到单链表的节点的个数（如果是带头节点的链表，不统计头结点）
    /**
     *
     * @param head 头结点
     * @return 返回的是有效节点的个数
     */
    public static int getLength(HeroNode2 head){
        if(head.next == null){//这是带头结点的空链表
            //System.out.println("链表为空！");
            return 0;
        }
        int length = 0;
        //这里没有统计头节点
        HeroNode2 cur = head.next;
        while (cur != null){
           length++;
           cur = cur.next;//遍历
        }
        return length;
    }
    //查找单链表中的倒数第K个节点
    /** 新浪面试题
     * 编写一个方法 接收头节点head 同时接受一个index(表示是倒数第index个节点)
     * 先把链表从头遍历一下 得到链表的长度getLength
     * 得到size后，我们从链表的第一个开始遍历
     * 如果找到了 就返回该节点 否则则返回null
     * @param
     */
    public static HeroNode2 findLastIndexNode(HeroNode2 head,int index){
        //判断如果链表为空，返回null
        if(head.next == null){
            return null;//没有找到
        }
        int size = getLength(head);//得到链表的长度
        //第二次遍历size - index位置，就是我们倒数的第k各节点
        //验证一下index
        if(index <= 0 || index > size){
            return null;
        }
        //辅助变量  for循环定位到倒数的index
        HeroNode2 cur = head.next;
        for(int i=0; i< size -index;i++){
           cur = cur.next;
        }
        return cur;
    }
    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点 实现逆序打印
    public static void reversePrint(HeroNode2 head){
        if(head.next == null){
            return;//空链表 不能打印
        }
        //创建一个栈，帮助我们遍历原来的链表
          //创建一个临时变量
        HeroNode2 cur = head.next;
        Stack<HeroNode2> stack = new Stack<HeroNode2>();
        while(cur != null){
            //将链表中的元素压入到栈中
            stack.push(cur);
            cur = cur.next;//当前节点后移
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());//栈的特点后进先出
        }
    }
    //将链表反转
    public static void reversetList(HeroNode2 head){
        //判断链表是否为空或者链表只有一个元素
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义辅助变量
        HeroNode2 cur = head.next;
        HeroNode2 next = null;//用于记录 指向当前节点的下一个节点
        HeroNode2 reverseHead = new HeroNode2(0,"","");//新链表的头结点
        //真正的工作
        while (cur != null){
            next = cur.next;//指向当前节点的下一个节点 后面要使用
            cur.next = reverseHead.next;//将当前的节点挂到新链表的最前端
            reverseHead.next = cur;//将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }
}
//定义singleLinkedList 管理我们的英雄
class SingleLinkedList2{
      //初始化头结点  不要动 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0,"","");
    //返回头结点
    public HeroNode2 getHead() {
        return head;
    }

    //添加节点到单向链表
    public void add(HeroNode2 heroNode2){
      //因为head节点不能动，因此我们需要一个辅助节点temp
      //判断链表是否已满
        HeroNode2 temp = head;
        //遍历链表 找到最后
        while (true){
            if(temp.next == null){
                break;
            }
            //如果没有找到 将temp后移
            temp = temp.next;
        }
        //当退出while 循环时 temp就指向了链表的最后
        temp.next = heroNode2;
    }
    //根据排名英雄插入到指定位置
    //（如果有这个排名，则添加失败，并给出提示）
    public void addByOrder(HeroNode2 heroNode2){
        //因为头结点不能动，因此我们仍然通过一个辅助变量 来找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则加入不进去
        HeroNode2 temp = head;
        boolean flag = false;//标志添加的编号是否存在 默认为false
        while (true){
           if(temp.next == null){
               break;
           }
           if(temp.next.no > heroNode2.no){//位置找到，就在temp的后面插入
               break;//说明希望添加的heroNode的编号依然存在 不能在添加了
           }else if(temp.next.no == heroNode2.no){
               flag = true;//说明编号已存在
               break;
           }
           temp = temp.next;//后移 遍历当前列表
        }
        //判断flag的值
        if(flag){
            System.out.printf("英雄编号%d 已存在，不能加入\n",heroNode2.no);
        }else{
             heroNode2.next = temp.next;
             temp.next = heroNode2;
        }
    }
    //修改信息 ，根据no编号来修改 即no编号不能改
      //根据new HeroNode的no来修改
    public void update(HeroNode2 newHeroNode){
        //判断是不是为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到该节点
        while(true){
            if(temp == null){
                break; //已经遍历完链表
            }
            if(temp.no == newHeroNode.no){
               //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else{//没有找到这个节点
            System.out.printf("没有找到编号 %d 的节点，不能修改\n",newHeroNode.no);
        }
    }
    //删除节点
    public void delete(int no){
        //判断链表是否为空
        /*if(head.next == null){
            System.out.println("链表为空，无法删除！");
            return;
        }*/
        //head不能动 temp临时变量 首先要找到前一个节点
        HeroNode2 temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){//已经到链表的最后了
                break;
            }
            if(temp.next.no == no){
              //找到了待删除的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;//temp后移，遍历
        }
        if(flag){
            //可以删除了
            temp.next = temp.next.next;
        }else{
            System.out.printf("要删除的 %d 节点不存在\n",no);
        }
    }
    //显示链表  辅助变量
    public void show(){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //因为头节点不能懂 需要一个辅助变量来遍历 至少有一个
        HeroNode2 temp = head.next;
        while (true){
            //判断是否到了链表最后
            if(temp == null){
               break;
            }
            //输出节点的信息
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }
}
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个节点

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
   //为了显示方便
    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
