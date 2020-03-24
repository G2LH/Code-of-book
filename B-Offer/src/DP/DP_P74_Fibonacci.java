package DP;

//斐波那契数列
public class DP_P74_Fibonacci {
    //dp[]动态规划
    int fib(int N) {
        int[] dp = new int[N+1];
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[N];
    }
    //递归,时间复杂度O(2^n)
    public static int fibonacci1(int n){
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci1(n - 1) +  fibonacci1(n - 2);
    }
    //备忘录法：当前状态只与前两个状态有关。存储前两个值,迭代计算,时间复杂度O(n)
    public static int fibonacci2(int n){
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        int temp1 = 0, temp2 = 1;
        int result = 0;
        for(int i = 1; i < n; i++){
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(fibonacci1(12));
        System.out.println(fibonacci2(13));
    }
}
