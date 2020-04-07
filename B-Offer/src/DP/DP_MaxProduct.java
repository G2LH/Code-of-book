package DP;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
//maxDP[i + 1] = max(maxDP[i] * A[i + 1], A[i + 1],minDP[i] * A[i + 1])
//minDP[i + 1] = min(minDP[i] * A[i + 1], A[i + 1],maxDP[i] * A[i + 1])
//dp[i + 1] = max(dp[i], maxDP[i + 1])
//
//这里，我们还需要注意元素为0的情况，如果A[i]为0，那么maxDP和minDP都为0，
//我们需要从A[i + 1]重新开始。

public class DP_MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        } else if(n == 1) {
            return nums[0];
        }
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < n; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(temp * nums[i], nums[i]), min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
