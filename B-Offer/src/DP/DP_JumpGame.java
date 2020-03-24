package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：

//给定一个非负整数数组，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//判断你是否能够到达最后一个位置。
public class DP_JumpGame {
    public boolean canJump(int[] nums) {

        if (nums == null) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果之前的j节点可达，并且从此节点可以到跳到i
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
    public boolean canJump1(int[] nums) {
        if (nums == null) {
            return false;
        }
        int last = nums.length -1;
        for(int i = nums.length-1; i >= 1; i--){
            if((nums[i-1] + i-1)>=last){
                last = i-1;
            }
        }
        return last == 0;
    }
}
