package com.atguigu.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：代表没有棋子，1代表黑子，2代表篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            //System.out.println(row);这是一个数组
            for (int value : row) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
        //System.out.println(chessArr1.length);
        //将二维数组转化为稀疏数组
        //1、先遍历二维数组得到非0数据的个数
        int sum = 0;
        for (int i=0;i< chessArr1.length;i++) {
            for (int j=0;j<chessArr1.length;j++){
                if(chessArr1[0][0]!=0){
                    sum++;
                }
            }
        }
        //System.out.println("sum="+sum);
       //创建对应的稀疏数组
        int sparerArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparerArr[0][0]=11;
        sparerArr[0][1]=11;
        sparerArr[0][2]=sum;
        //遍历二维数组，将非零的值存到sparseArr
        //赋值
        int count = 0;//用于记录第几个非零数据
        for (int i=0;i< 11;i++) {
            for (int j=0;j<11;j++){
                if(chessArr1[0][0]!=0){
                   count++;
                   sparerArr[count][0]=i;
                   sparerArr[count][1]=j;
                   sparerArr[count][2]=chessArr1[i][j];
                    System.out.println(count);
                }
            }
        }
        System.out.println(sparerArr.length);
        //输出稀疏数组的形式
        /*for (int i=0;i<sparerArr.length;i++){
            System.out.printf("%d\t%d\t%d\t",sparerArr[i][0],sparerArr[i][1],sparerArr[i][2]);
        }*/

    }
}
