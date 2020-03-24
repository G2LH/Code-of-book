//0~n中缺失的数字
//题目要求：
//一个长度为n的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n之内。在范围0~n内的n个数字有且只有一个数字不在该数组中，请找出。
public class P266_GetMissingNumber {
    //1.有序的data
    public static int getMissingNumber(int[] data){
        int left = 0, right = data.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right)/2;
            if(data[mid] == mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return  left;
    }
    //2.无序的data 数组对应索引下标 通过将每个索引对应的元素变成负数，以表示这个索引被对应过一次了
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            // nums[index] 小于 0 则说明重复访问
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }

        int missing = -1;
        for (int i = 0; i < n; i++)
            // nums[i] 大于 0 则说明没有访问
            if (nums[i] > 0)
                missing = i;

        return new int[]{dup, missing};
    }
    public static void main(String[] args){
        int[] data1 = new int[]{0,1,2,3,4,5}; //6
        int[] data2 = new int[]{0,1,3,4,5}; //2
        int[] data3 = new int[]{1,2}; //0
        System.out.println(getMissingNumber(data1));
        System.out.println(getMissingNumber(data2));
        System.out.println(getMissingNumber(data3));
    }
}
