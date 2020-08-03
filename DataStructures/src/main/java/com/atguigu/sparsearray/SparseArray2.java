package com.atguigu.sparsearray;

import org.junit.jupiter.api.Test;

public class SparseArray2 {
    //将棋盘转化为二维数组到稀疏数组并保存
    @Test
    public void test(){
       //创建二维数组
        int[][] chessArr = new int[6][7];
        //给二维数组中的元素赋值 棋盘刻盘完成
        chessArr[0][3]=22;
        chessArr[0][6]=15;
        chessArr[1][1]=11;
        chessArr[1][5]=17;
        chessArr[2][3]=-6;
        chessArr[3][5]=39;
        chessArr[4][0]=91;
        chessArr[5][2]=28;
        //验证一下  至此棋盘保存成功
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("\t"+data);
            }
            System.out.println();
        }
        //数组的长度
        //System.out.println(chessArr.length);
         //转化为稀疏数组
          //1、遍历二维数组不为零的元素
         int sum = 0; //临时变量用来存储二维数组中的值的个数
         for (int i=0;i<chessArr.length;i++){
             for (int j=0;j<7;j++){
                 //判断其中不为零的元素的个数
                 if(chessArr[i][j]!=0){
                     sum++;
                 }
             }
         }
        //System.out.println(sum);
         //创建稀疏数组 行不确定 列为3
         int[][] sparseArr = new int[sum+1][3];
         //确定第一行的值
         sparseArr[0][0]=6;
         sparseArr[0][1]=7;
         sparseArr[0][2]=sum;
         //为其他元素赋值
        //System.out.println(sparseArr.length);
        int count = 0;//用于记录第几个非零的数据 在稀疏数组中的位置
        for (int i=0;i<chessArr.length;i++){
            for (int j=0;j<7;j++){
                //判断其中不为零的元素的个数
                if(chessArr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr[i][j];
                }
            }
        }
        //少写for循环
        System.out.println();
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        //在从稀疏数组转到二维数组
         //首先获取稀疏数组的第一行 就是sparseArr[0][0]，sparseArr[0][1]
         int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
         //读取稀疏数组后几行的值为二维数组赋值
        for (int i=1;i<sparseArr.length;i++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] =sparseArr[i][2];
        }
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }
}
