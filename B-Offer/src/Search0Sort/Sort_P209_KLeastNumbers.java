package Search0Sort;
//最小的k个数
//题目要求：
//找出n个整数中最小的k个数

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sort_P209_KLeastNumbers {
    //1.快排分区
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length == 0 || input == null || k > input.length){
            return new ArrayList<>();
        }
        int left = 0, right = input.length - 1;
        int index = partition(input, left, right);
        while(k - 1 != index){
            if(k - 1 > index) {
                index = partition(input, index + 1, right);
            }else{
                index = partition(input,left,index - 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<=index; i++){
            list.add(input[i]);
        }
        return list;
    }
    public static int partition(int[] input, int left, int right){
        int pivot = input[left];
        while(left < right){
            while(left<right && input[right] >= pivot){
                right--;
            }
            if(left<right){
                input[left] = input[right];
            }
            while(left<right && input[left] < pivot){
                left++;
            }
            if(left<right){
                input[right] = input[left];
            }
        }
        input[left] = pivot;
        return left;
    }

    //2.遍历K次
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || input == null || k > input.length || k <= 0){
            return list;
        }
        for(int i = 0; i < k; i++){
            for(int j = i + 1; j < input.length; j++){
                if(input[i] > input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            list.add(input[i]);
        }
        return list;
    }
    //3.利用堆进行排序
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] array, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        //创建一个降序排列的PriorityQueue，自定义比较器作为参数
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int i=0;i<array.length;i++){
            if(priorityQueue.size()<k){
                priorityQueue.add(array[i]);
            }else{
                int maxInQueue = priorityQueue.peek();
                if(maxInQueue>array[i]){//每次取数与堆顶的元素进行比较，
                    //如果堆顶元素大，则删除堆顶元素，并添加这个新数到堆中
                    priorityQueue.poll();
                    priorityQueue.add(array[i]);
                }
            }
        }
        //升序存放
        for(int i=0;i<k;i++){
            list.add(priorityQueue.poll());
        }
        return list;
    }

    public static void main(String[] args){
        int[] data1 = {1,3,5,7,2,4,6,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(data1,4);
        for(int i = 0; i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}
