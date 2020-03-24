package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：
public class DP_P304_MaximalProfit {
    //股票利润最大
    //题解：遍历时 记录min，profit，更新min，profit
    public static int maxDiff(int[] data){
        if(data == null || data.length < 2){
            return -1;
        }
        int min = data[0];
        int profit = data[1] - min;
        for(int i = 1; i < data.length; i++){
            if(data[i] - min > profit){
                profit = data[i] - min;
            }
            if(data[i] < min){
                min = data[i];
            }
        }
        return profit;
    }
    public static void main(String[] args){
        int[] data1 = new int[]{9,11,8,5,7,12,16,14};
        int[] data2 = new int[]{9,8,7,6,5,4,3,1};
        //System.out.println(maxDiff(data1)); //11
        System.out.println(maxDiff(data2)); //-1
    }
}
