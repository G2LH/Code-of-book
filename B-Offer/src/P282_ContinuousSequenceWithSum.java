import java.util.ArrayList;
//和为sum的连续子序列
public class P282_ContinuousSequenceWithSum {
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum <= 1){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        int left = 1, right = 2;
        int curSum = left + right;
        while(right <= sum && left != right){
            if(curSum < sum){
                right++;
                curSum += right;
            }else if(curSum > sum){
                curSum -= left;
                left++;
            }else{
                ArrayList<Integer> seq = new ArrayList<>();
                for(int j = left; j <= right; j++){
                    seq.add(j);
                }
                array.add(seq);
                curSum -= left;
                left++;
            }
        }
        return array;
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res = FindContinuousSequence(15);
    }
}
