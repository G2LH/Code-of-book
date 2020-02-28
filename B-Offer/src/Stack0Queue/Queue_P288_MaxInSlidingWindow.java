package Stack0Queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class Queue_P288_MaxInSlidingWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> array = new ArrayList<>();
        if(num == null || num.length ==0 || size == 0){
            return new ArrayList<>();
        }
        LinkedList<Integer> q = new LinkedList<>();
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
    public static void main(String[] args){
        ArrayList<Integer> array;
        int[] num = {2,3,4,5,6};
        array = maxInWindows(num,2);
        System.out.print(array);
    }
}
