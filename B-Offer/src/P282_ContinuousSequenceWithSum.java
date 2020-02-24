import java.util.ArrayList;

public class P282_ContinuousSequenceWithSum {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
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
}