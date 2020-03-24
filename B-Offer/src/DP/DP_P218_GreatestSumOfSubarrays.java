package DP;
////状态定义：
////转移方程：
////初始状态：
////返回值：

//连续子数组的最大和
//题目要求：
//输入一个整形数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。求所有子数组的和的最大值，要求时间复杂度为o(n)。
public class DP_P218_GreatestSumOfSubarrays {
    //1.
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum>0){
                sum+=nums[i];
            }else{
                sum = nums[i];
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    //2.max( dp[ i ] ) = getMax( max( dp[ i -1 ] ) + arr[ i ] ,arr[ i ] )
    public static int FindGreatestSumOfSubArray(int[] nums) {
            int n = nums.length, maxSum = nums[0];
            for(int i = 1; i < n; ++i) {
                if (nums[i - 1] > 0) nums[i] += nums[i - 1];
                maxSum = Math.max(nums[i], maxSum);
            }
            return maxSum;
        }
    public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(data));
    }
}
