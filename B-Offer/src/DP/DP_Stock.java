package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：
public class DP_Stock {
    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    //注意你不能在买入股票前卖出股票。

    public int maxProfit_k_11(int[] prices) {
        if(prices == null){
            return -1;
        }
        if(prices.length < 2){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - min > profit){
                profit = prices[i] - min;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return profit;
    }
    //动态规划:状态 dp[i][j] 定义
    //第一维 i 表示索引为 i 的那一天（具有前缀性质，即考虑了之前天数的收益）能获得的最大利润；
    //第二维 j 表示索引为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金（cash），1 表示持有股票
    int maxProfit_k_12(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }


//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //贪心
    public int maxProfit_k_inf1(int[] prices) {
        if(prices == null || prices.length <=1){
            return 0;
        }
        int max = 0;
        for(int i = 0; i<prices.length-1; i++){
            max += Math.max(prices[i + 1] - prices[i], 0);
        }
        return max;
    }
    //动态规划
    public int maxProfit_k_inf2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    int maxProfit_k_inf3(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }


    //每次 sell 之后要等一天才能继续交易
    int maxProfit_with_cool(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
    //每次交易要支付手续费，只要把手续费从利润中减去即可
    int maxProfit_with_fee(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
    //每天可进行K比交易int max_k = 2;
//    dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
//    dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
//    dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
//    dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
    int maxProfit_k_2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
//    int maxProfit_with_K(int[] prices, int fee) {
//        int[][][] dp = new int[n][max_k + 1][2];
//        for (int i = 0; i < n; i++) {
//            for (int k = max_k; k >= 1; k--) {
//                if (i - 1 == -1) {
//                    /* 处理 base case */
//                    dp[i][k][0] = 0;
//                    dp[i][k][1] = -prices[i];
//                    continue;
//                }
//                dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
//                dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
//            }
//        }
//        // 穷举了 n × max_k × 2 个状态，正确。
//        return dp[n - 1][max_k][0];
//    }
}
