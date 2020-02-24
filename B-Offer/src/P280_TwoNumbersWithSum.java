import java.util.ArrayList;

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
