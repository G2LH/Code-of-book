import java.util.Arrays;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//必须原地修改，只允许使用额外常数空间。

//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class Next_Permutation {
    //先排序后交换
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int i = nums.length-1;
        while(i>0 && nums[i] <= nums[i-1]){//先找到分界点
            i--;
        }
        Arrays.sort(nums,i,nums.length);//将分界点后的数排序
        if(i>0) {
            for (int j = i; j < nums.length; j++){ //寻找第一个大于分界点前一个的数
                if (nums[j] > nums[i-1]){ //交换
                    int temp = nums[i-1];
                    nums[i-1] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
    }
}
