import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrack_Permute {
    //1.给定一个 没有重复 数字的序列，返回其所有可能的全排列
    private List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }
    public void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    //2.给定一个可包含重复数字的序列，返回所有不重复的全排列。
    List<List<Integer>> res1 = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res1;
    }
    public void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res1.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                continue;
            }
            //i-1和i的值相等，且i-1没被用过（之后可能会被用就产生重复）
            //flag[i-1]=false是取相等的数中最左边的那个数当ll的第一个数，
            //而flag[i-1]=true就是取相等的数中最右边的那个数当ll的第一个数，也就是说分别取第一行和第二行。
            if(i>0&&nums[i-1]==nums[i]&&used[i-1]==false)
            {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }

}
