package DP;
//状态定义：dp[i] 的值代表 nums 前 ii 个数字的最长子序列长度。
//转移方程：dp[i]=max(dp[j])+1    ---  dp[i] = max(dp[i], dp[j]+1)
//初始状态：dp[i] 所有元素置 11，含义是每个元素都至少可以单独成为子序列，此时长度都为 11。
//返回值：返回 dpdp 列表最大值，即可得到全局最长上升子序列长度。
import java.util.Arrays;
//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//dp[i]的值代表以nums[i]结尾的最长子序列长度
public class DP_LongestUpSequence {
        public int lengthOfLIS(int[] nums) {
            if(nums.length == 0||nums == null){
                return 0;
            }
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int res = 0;
            for(int i = 0; i<nums.length;i++){
                for(int j = 0; j<i; j++){
                    if(nums[i]>nums[j]){
                        dp[i] = Math.max(dp[i],dp[j]+1);////内层循环求多个dp[i]
                    }
                }
                res= Math.max(res,dp[i]);
            }
            return res;
        }
}
