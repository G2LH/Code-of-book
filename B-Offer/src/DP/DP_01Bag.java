package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：
import java.util.Scanner;
//0-1 背包问题：当前考虑的物品用或者不用；
//声明一个 大小为  m[n][c] 的二维数组，m[ i ][ j ] 表示 在面对第 i 件物品，且背包容量为  j 时所能获得的最大价值 ，那么我们可以很容易分析得出 m[i][j] 的计算方法
//（1）. j < w[i] 的情况，这时候背包容量不足以放下第 i 件物品，只能选择不拿
//m[ i ][ j ] = m[ i-1 ][ j ]
//（2）. j>=w[i] 的情况，这时背包容量可以放下第 i 件物品，我们就要考虑拿这件物品是否能获取更大的价值。
//如果拿取，m[ i ][ j ]=m[ i-1 ][ j-w[ i ] ] + v[ i ]。
public class DP_01Bag {
        public static int getMaxValue(int[] w, int[] v, int m, int n){
            int[][] bag = new int[n+1][m+1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(w[i] > j){
                        bag[i][j] = bag[i-1][j];
                    }else{
                        bag[i][j] = Math.max(bag[i-1][j],bag[i-1][j-w[i]]+v[i]);
                    }
                }
            }
            return bag[n][m];
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int maxWeight = sc.nextInt();
            int[] weight = new int[n+1];
            int[] value = new int[n+1];
            for(int i = 1; i < n+1; i++){
                weight[i] = sc.nextInt();
            }
            for(int i = 1; i < n+1; i++){
                value[i] = sc.nextInt();
            }
            System.out.println(getMaxValue(weight, value, maxWeight, n));
        }
}
