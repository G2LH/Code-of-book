package DP;

//连续子数组的最大和
//题目要求：
//输入一个整形数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。求所有子数组的和的最大值，要求时间复杂度为o(n)。
public class DP_P218_GreatestSumOfSubarrays {
    //1.
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0){
            return -1;
        }
        int sum = 0, max = array[0];
        for(int i = 0; i < array.length; i++){
            if(sum <= 0){
                sum = array[i];
            }else{
                sum += array[i];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(data));
    }
}
