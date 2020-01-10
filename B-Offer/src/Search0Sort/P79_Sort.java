package Search0Sort;

import P58_PrintListInReversedOrder.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P79_Sort {
    //数组快排，时间o(nlogn)(最差n^2)，空间o(logn)(最差n)，递归造成的栈空间的使用，不稳定
    public static void quickSort(int[] data){
        if(data == null || data.length <= 1) return;
        QuickSort(data, 0, data.length - 1);
    }
    public static void QuickSort(int[] data, int start, int end){
        if(end - start <= 0) return;
        int index = quickSortPartition(data, start, end);
        QuickSort(data, start, index - 1);
        QuickSort(data, index + 1, end);
    }
    public static  int quickSortPartition(int[] data, int start, int end){
        int pivot = data[start];  //枢轴记录
        int left = start;
        int right = end;
        while(left < right){
            while (left < right && data[right] >= pivot)
                right--;
            if(left < right)
                data[left] = data[right];    //交换比枢轴小的记录到左端
            while (left < right && data[right] < pivot)
                left++;
            if(left < right)
                data[right] = data[left];   //交换比枢轴小的记录到右端
        }
        data[left] = pivot;         //扫描完成，枢轴到位
        return left;                //返回的是枢轴的位置
    }
    public static void testQuickSort(){
        int[] data = {5,4,3,2,1};
        quickSort(data);
        System.out.println("快排");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
    //通过List完成快排
    public static void quickSortList(List<Integer> data){
        if(data==null || data.size()<2)
            return;
        quickSortListCore(data,0,data.size()-1);
    }
    public static void quickSortListCore(List<Integer> data,int start,int end){
        if(start>=end)
            return;
        int index = quickSortListPartition(data,start,end);
        quickSortListCore(data,start,index-1);
        quickSortListCore(data,index+1,end);
    }
    public static int quickSortListPartition(List<Integer> data,int start,int end){
        int pivot = data.get(start);
        int left = start,right = end;
        while(left<right){
            while(left<right && data.get(right)>=pivot)
                right--;
            if(left<right)
                data.set(left,data.get(right));
            while(left<right && data.get(left)<pivot)
                left++;
            if(left<right)
                data.set(right,data.get(left));
        }
        data.set(left,pivot);
        return left;
    }
    public static void testQuickSortList(){
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(5);
        data.add(4);
        data.add(2);
        data.add(3);
        quickSortList(data);
        System.out.print("基于List快速排序:\t");
        System.out.println(data);
    }




    //数组二路归并，时间o(nlogn)，空间o(n)，稳定
    public static int[] mergeSort(int[] data){
        if(data == null || data.length <= 1)
            return data;
        mergeSortCore(data, 0, data.length - 1);
        return  data;
    }
    public static void mergeSortCore(int[] data, int start, int end){
        if(start >= end)
            return;
        int mid = start + (end - start)/2;
        mergeSortCore(data, start, mid);
        mergeSortCore(data, mid + 1, end);
        mergeSortMerge(data, start, mid, end);
    }
    public static void mergeSortMerge(int[] data, int start, int mid, int end){
        if(end == start)
            return;
        int[] temp = new int[end - start + 1];//temp数组用于暂存合并的结果
        int left = start, right = mid + 1, tempIndex = 0;//左右半边的指针，合并后数组的指针
        while(left <= mid && right <= end){ // 把较小的数先移到新数组中
            if(data[left] <= data[right])
                temp[tempIndex++] = data[left++];
            else
                temp[tempIndex++] = data[right++];
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while(left <= mid) // 把左边剩余的数移入数组
            temp[tempIndex++] = data[left++];
        while (right <= end)// 把右边边剩余的数移入数组
            temp[tempIndex++] = data[right++];
        for(int i = 0; i < temp.length; i++)  // 把新数组中的数覆盖nums数组
            data[start+i] = temp[i];
    }
    public static void testMergeSort(){
        int[] data = {5,4,3,1,2};
        mergeSort(data);
        System.out.print("数组归并排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }




    //数组堆排序，时间o(nlogn)，空间o(1),不稳定,建立最大堆，交换堆的第一个与最后一个元素，调整堆
    public static void heapSort(int[] data){
        if(data == null || data.length <= 1)
            return;
        //1.堆构造
        buildMaxHeap(data);
        //2.将堆顶元素与尾节点交换排序
        for(int indexBound = data.length-1; indexBound >= 0;){
            int temp = data[indexBound];
            data[indexBound] = data[0];
            data[0] = temp;
            indexBound--;
            adjustMaxHeap(data,0,indexBound);
        }
    }
    public static void buildMaxHeap(int[] data){
        //由下自上,依次调整，i=data.length/2-1是最后一个节点的父节点,i=0是第一个节点
        // 因为(data.length/2-1)~0的节点才有子节点
        for(int i = data.length/2-1; i>=0;i--){
            adjustMaxHeap(data,i,data.length-1);
        }
    }
    public static void adjustMaxHeap(int[] data,int i, int end){
        //i表示待调整元素下标，end表示最大堆的最后一个元素的下标，end值会随着排序的进行而减小到1
        int left = 2*i+1;//左孩子节点
        int right = 2*i+2;//右孩子节点
        int max = i;
        if(left <= end && data[left]>data[max])
            max = left;
        if(right <= end && data[right]>data[max])
            max = right;
        //如果左右孩子节点的最大值比父节点值大的时候，交换
        //递归的调整左右节点中最大的节点的分支
        if(max!=i){
            int temp = data[max];
            data[max] = data[i];
            data[i] = temp;
            adjustMaxHeap(data,max,end);
        }
    }
    public static void testHeapSort(){
        int[] data = {5,4,3,1,2};
        heapSort(data);
        System.out.print("数组堆排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }




    //数组冒泡，时间o(n^2)，空间o(1)，稳定
    public static void bubbleSort(int[] data){
        if(data==null || data.length<=1)
            return;
        //外层循环是排序的趟数
        for(int i=0;i<data.length-1;i++){
            //内层循环是当前趟数需要比较的次数
            for(int j=0;j<data.length-i-1;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }
    public static void testBubbleSort(){
        int[] data = {5,4,3,1,2};
        bubbleSort(data);
        System.out.print("数组冒泡排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }




    //数组选择排序，时间o(n^2)，空间o(1)，不稳定
    public static void selectionSort(int[] data){
        if(data==null || data.length<=1)
            return;
        for(int i=0;i<data.length-1;i++){
            int minIndex = i;//未排序序列中最小数据数组下标
            for(int j=i+1;j<data.length;j++){//在未排序元素中继续寻找最小元素，并保存其下标
                if(data[j]<data[minIndex])
                    minIndex = j;
            }
            if(i!=minIndex) {//将最小元素放到已排序序列的末尾
                int temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }
    public static void testSelectionSort(){
        int[] data = {5,4,3,1,2};
        selectionSort(data);
        System.out.print("数组选择排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }




    //数组插入排序，时间o(n^2)，空间o(1)，稳定
    public static void insertionSort(int[] data){
        if(data==null || data.length<=1)
            return;
        //从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序
        for(int i=1;i<data.length;i++){
            int j=i;
            int temp = data[i];//记录要插入的数据
            while(j>0 && data[j-1]>temp){//从已经排序的序列最右边的开始比较，找到比其小的数
                data[j] = data[j-1];//向后挪动
                j--;
            }
            data[j] = temp;//存在比其小的数插入
        }
    }
    public static void testInsertionSort(){
        int[] data = {5,4,3,1,2};
        insertionSort(data);
        System.out.print("数组插入排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }




    //数组希尔排序(插入排序缩小增量)，时间o(n^1.3)，空间o(1)，不稳定
    public static void shellSort(int[] data){
        if(data==null || data.length<=1)
            return;
        //进行分组，并逐步缩小增量
        for(int gap=data.length/2;gap>0;gap=gap/2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<data.length;i++){
                int j = i;
                while(j-gap>=0 && data[j]<data[j-gap]){
                    int temp = data[j];
                    data[j] = data[j-gap];
                    data[j-gap] = temp;
                    j-=gap;//对分组内数量大于2的分组进行排序
                }
            }
        }
    }
    public static void testShellSort(){
        int[] data = {5,4,3,1,2};
        shellSort(data);
        System.out.print("数组希尔排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }



    public static void main(String[] args){
        testQuickSort();
        testQuickSortList();
        testMergeSort();
        testHeapSort();
        testBubbleSort();
        testSelectionSort();
        testInsertionSort();
        testShellSort();
    }
}
