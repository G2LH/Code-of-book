import java.util.ArrayList;
//和为S的所有子序列集合，用双指针
public class NumberOfSequenceSumIsS {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int l=1,r=1;
        int sum = 1;
        while(r<=target/2+1&&l<=target/2+1){
            if(sum<target){
                r++;
                sum+=r;
            }
            if(sum>target){
                sum-=l;
                l++;
            }
            if(sum == target){
                int[] res = new int[r-l+1];
                for(int i = 0; i<r-l+1; i++){
                    res[i] = i+l;
                }
                list.add(res);
                sum-=l;
                l++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
