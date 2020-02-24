import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P214_StreamMedian {
    //链表排序
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void Insert(Integer num) {
        list.add(num);
    }
    public static Double GetMedian() {
        if(list.size() == 0){
            return 0.0;
        }
        int mid = list.size()/2;
        int left = 0, right = list.size() - 1;
        int index = partition(left,right);
        while(mid != index){
            if(mid < index){
                index = partition(left,index - 1);
            }else{
                index = partition(index + 1,right);
            }
        }
        if(list.size()%2==0){
            return (list.get(mid)+list.get(mid-1))/2.0;
        }else{
            return Double.valueOf(list.get(mid));
        }
    }
    public static int partition(int left,int right){
        int pivot = list.get(left);
        while(left<right){
            while(left<right && pivot <= list.get(right)){
                right--;
            }
            if(left<right){
                list.set(left,list.get(right));
            }
            while(left<right && pivot > list.get(right)){
                left++;
            }
            if(left<right){
                list.set(right,list.get(left));
            }
        }
        list.set(left, pivot);
        return left;
    }
//大顶堆，小顶堆
    private static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer o1,Integer o2){
            return o2-o1;
        }
    });
    private static int count=0;
    public static void Insert1(Integer num) {
        count++;
        if(count%2==0){   //偶数，插入最小堆
            if(!maxHeap.isEmpty() && num<maxHeap.peek()){ //如果num小于最大堆，那么先插入最大堆
                maxHeap.add(num);
                num=maxHeap.poll();
            }
            minHeap.add(num);
        }else{ //奇数，插入最大堆
            if(!minHeap.isEmpty() && num>minHeap.peek()){
                minHeap.add(num);
                num=minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public static Double GetMedian1() {
        if(minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2.0;
        else if(maxHeap.size()>minHeap.size())
            return maxHeap.peek()/1.0;
        else
            return minHeap.peek()/1.0;
    }

    public static void main(String[] args){
        Insert(2);
        Insert(1);
        System.out.println(GetMedian());
    }
}
