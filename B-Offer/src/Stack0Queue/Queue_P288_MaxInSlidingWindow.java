package Stack0Queue;
//滑动窗口的最大值
//题目要求：
//给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
// 例如，输入数组{2,3,4,2,6,2,5,1}和数字3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
import java.util.ArrayList;
import java.util.LinkedList;

public class Queue_P288_MaxInSlidingWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> array = new ArrayList<>();
        if(num == null || num.length ==0 || size == 0){
            return new ArrayList<>();
        }
        LinkedList<Integer> q = new LinkedList<>();//存储下标
        for(int i = 0; i < num.length; i++){
            if(!q.isEmpty()){
                // 如果队列头元素不在滑动窗口中了，就删除头元素
                if(i - size >= q.peek()){
                    q.poll();
                }
                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while(!q.isEmpty() && num[i] >= num[q.getLast()]){
                    q.removeLast();
                }
            }
            q.offer(i);
            if(i + 1 >= size){
                array.add(num[q.peek()]);
            }
        }
        return array;
    }
    //暴力解法
    //    public int[] maxSlidingWindow(int[] nums, int k) {
    //            if(nums.length * k == 0){
    //                return new int[0];
    //            }
    //            int[] res = new int[nums.length-k+1];
    //            for(int i = 0; i < nums.length-k+1;i++){
    //                int max = Integer.MIN_VALUE;
    //                for(int j = i; j < i + k; j++){
    //                    max = Math.max(nums[j],max);
    //                }
    //                res[i] = max;
    //            }
    //            return res;
    //    }
    public static void main(String[] args){
        ArrayList<Integer> array;
        int[] num = {2,3,4,5,6};
        array = maxInWindows(num,2);
        System.out.print(array);
    }
}
