package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：

//礼物的最大值
//
//题目要求：
//在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
// 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值
public class DP_P233_MaxValueOfGifts {
    //1.递归 f(i,j) = max(f(i-1,j) , f(i,j-1)) + value(i,j);
    public static int GetMaxValueOfGifts(int[][] gifts, int row, int col){
        //当来到左上角时，终止条件
        if(row == 0 && col == 0){
            return gifts[0][0];
        }
        if(row == 0){
            return GetMaxValueOfGifts(gifts,row,col-1)+gifts[row][col];
        }else if(col==0){
            return GetMaxValueOfGifts(gifts,row-1,col)+gifts[row][col];
        }else{
            return max(GetMaxValueOfGifts(gifts,row-1,col),GetMaxValueOfGifts(gifts,row,col-1))+gifts[row][col];
        }
    }
    public static int max(int num1,int num2){
        if(num1>num2){
            return num1;
        }else{
            return num2;
        }
    }
    //动态规划：定义二维数组来保存中间结果
    public static int getMaxValue(int[][] a) {
        if(a==null||a.length==0||a[0].length==0)
            return 0;
        int row = a.length;
        int col = a[0].length;
        //定义二维数组来保存中间结果
        int[][] maxValues = new int[row][col];
        for(int i = 0;i < row;i++)
            for(int j =0;j < col;j++)
            {
                //原点
                if(i==0 && j==0)
                {
                    maxValues[i][j] = a[i][j];
                }
                //上边界
                else if(i==0 && j!=0)
                {
                    maxValues[i][j] = a[i][j] + maxValues[i][j-1];
                }
                //左边界
                else if(i!=0&&j==0)
                {
                    maxValues[i][j] = a[i][j] + maxValues[i-1][j];
                }
                else {
                    maxValues[i][j] = a[i][j] + Math.max(maxValues[i][j-1], maxValues[i-1][j]);
                }

            }
        return maxValues[row-1][col-1];
    }
    public static void main(String[] args){
        int[][] data = {
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}};
        System.out.println(GetMaxValueOfGifts(data,data.length - 1,data[0].length - 1));
    }
}
