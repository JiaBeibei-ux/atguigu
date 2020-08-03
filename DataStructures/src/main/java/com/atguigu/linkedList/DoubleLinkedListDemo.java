package com.atguigu.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode3 heroNode1 = new HeroNode3(1,"宋江","及时雨");
        HeroNode3 heroNode2 = new HeroNode3(2,"卢俊义","玉麒麟");
        HeroNode3 heroNode3 = new HeroNode3(3,"吴用","智多星");
        HeroNode3 heroNode4 = new HeroNode3(4,"林冲","豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.show();
        System.out.println("=============");
        //修改
        HeroNode3 newHeroNode = new HeroNode3(4,"公孙胜","豹子头");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.show();
        System.out.println("=============");
        doubleLinkedList.del(3);
        doubleLinkedList.show();
    }
}
class DoubleLinkedList{
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode3 head = new HeroNode3(0,"","");

    public HeroNode3 getHead() {
        return head;
    }
    //显示链表  辅助变量
    public void show(){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //因为头节点不能懂 需要一个辅助变量来遍历 至少有一个
        HeroNode3 temp = head.next;
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
    //添加一个节点到双向链表的最后
    public void add(HeroNode3 heroNode){
        //因为head节点不能动，因此我们需要一个辅助接点temp
        HeroNode3 temp = head;
        //遍历链表
        while(true){
            if(temp.next == null){
                break;//链表已经到便利完了
            }
            temp = temp.next;//后移
        }
        //这是单向链表
        /*//当退出循环时 temp就指向了链表的最后了
        //将最后这个节点的next指向新节点
        //temp.next = heroNode;*/
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改双向链表  和单项链表修改一样
    public void update(HeroNode3 heroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号修改
           //辅助变量不可少
        HeroNode3 temp = head.next;
        boolean flag = false;//是否找到节点
        while(true){
            if(temp == null){
                break;//已经遍历完链表
            }
            if(temp.no == heroNode.no){
                //找到要修改的节点了
                flag = true;
                break;
            }
            temp = temp.next;//指针后移
        }
        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else {
            System.out.printf("没有找到 %d 的节点，不能修改\n",heroNode.no);
        }
    }
    //从双向链表删除一个节点
    //对于双向链表 直接找到要删除的这个节点
    //找到后 自我删除即可
    public void del(int no){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空，无法删除！");
            return;
        }
        //head不能动 temp临时变量    单链表中的首先要找到前一个节点
        HeroNode3 temp = head.next;
        boolean flag = false;//标注是否找到了删除的节点
        while (true){
            if(temp == null){//已经找到最后了 链表最后一个的后一个
                break;
            }
            if(temp.no == no){
              //找到带删除的节点
              flag = true;
              break;
            }
            temp = temp.next;//next后移
        }
        if(flag){//找到了要的删除的节点
            //temp.next = temp.next.next;单向链表的删除
            temp.pre.next = temp.next;
            //如果是最后一个节点 就不需要执行这句话，否则会出错 空指针
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }
}
class HeroNode3{
    public int no;
    public String name;
    public String nickname;
    public HeroNode3 next;//指向下一个节点 默认null
    public HeroNode3 pre; //指向上一个节点 默认null

    public HeroNode3(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode3{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}