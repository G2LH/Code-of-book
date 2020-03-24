import java.util.ArrayList;
//题目要求：
//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使它们的和为s。如果有多对和为s，输入任意一对即可。
//题解：双指针
public class P280_TwoNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array == null || array.length < 2){
            return new ArrayList();
        }
        ArrayList<Integer> two = new ArrayList<>();
        int curSum = 0;
        int left = 0, right = array.length - 1;
        while(curSum!=sum){
            if(left >= right){
                return new ArrayList();
            }
            if((array[left]+array[right])<sum){
                left++;
            }else if((array[left]+array[right])>sum){
                right--;
            }else{
                curSum = array[left]+array[right];
                two.add(array[left]);
                two.add(array[right]);
            }
        }
        return two;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,4,7,11,15};
        ArrayList<Integer> array = FindNumbersWithSum(data,15);
        System.out.println(array.get(0));
        System.out.println(array.get(1));
    }
}
