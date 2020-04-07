import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack_Combination {
    //1.给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的数字可以无限制重复被选取。
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, list, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, List list, int index){
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] <= target){
                list.add(candidates[i]);
                backtrack(candidates, target-candidates[i], list, i);//每个元素能取多次
                list.remove(list.size() - 1);
            }
        }
    }

    //2.给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的每个数字在每个组合中只能使用一次。
    //说明：
    //所有数字（包括目标数）都是正整数。
    //解集不能包含重复的组合。 

    //为了使得解集不包含重复的组合。我们想一想，如何去掉一个数组中重复的元素，除了使用哈希表以外，我们还可以先对数组升序排序，重复的元素一定不是排好序以后的第 1 个元素和相同元素的第 1 个元素。
    //根据这个思想，我们先对数组升序排序是有必要的。候选数组有序，对于在递归树中发现重复分支，进而“剪枝”也是有效的
    private List<List<Integer>> res1 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,target,list,0);
        return res;
    }
    public void backTrack(int[] candidates, int target,List<Integer> list,int index){
        if(target == 0){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target < candidates[i]){
                return;
            }
            // 去除重复的解， 这种理论依据是排序过的数组， 如果非起始分支， 并且数值与前一个分支相同， 则此分支可以剪枝，
            // 因为前一个分支的数据遍历范围是大于此分支的，
            // 如果还相同， 那此份之属于与前一个分支肯定是相同的， 这也是回溯算法剪枝的常用套路之一
            if( i > index && candidates[i - 1] == candidates[i]){//去除子集中重复的解
                continue;
            }
            list.add(candidates[i]);
            backTrack(candidates,target - candidates[i], list, i+1);//每个元素只能取一次
            list.remove(list.size()-1);
        }
    }
}
