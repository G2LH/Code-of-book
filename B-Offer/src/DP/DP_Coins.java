package DP;

import java.util.Arrays;
public class DP_Coins {
    //1.给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
    //dp[i] = x 表示，当目标金额为 i 时，至少需要 x 枚硬币。
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0; i < amount+1;i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for(int i = 0; i<dp.length; i++){
            for(int coin:coins){
                if(i-coin<0){
                    continue;
                }
                dp[i] = Math.min(dp[i],dp[i-coin] + 1);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    //2.给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
    //这道题是典型的“完全背包问题”。“完全背包问题”的特点是：背包里的物品可以无限次选取。
    //    0-1 背包问题：当前考虑的物品用或者不用；
    //    完全背包问题：当前考虑的物品用或者不用，如果用，用几个。
    //DP:
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[][] dp = new int[amount + 1][len+ 1];
        //设置基本条件
        for (int i = 0; i <= len; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j <= len; j++) {
                if (i < coins[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j];
                }
            }
        }
        return dp[amount][len];
        //                           不用这枚硬币                        用这枚硬币
        //                      =之前没有这枚硬币的情况          =总金额少掉这枚硬币的情况
    }
    public int change0(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
    //回溯法
    private int res = 0;
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);
        backtracking(amount, coins, 0, len);
        return res;
    }
    private void backtracking(int residue, int[] coins, int start, int len) {
        if (residue == 0) {
            res++;
            return;
        }

        for (int i = start; i < len; i++) {
            if (residue - coins[i] < 0) {
                break;
            }
            backtracking(residue - coins[i], coins, i, len);
        }
    }
}
