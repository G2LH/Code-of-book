//数组中的逆序对
//题目要求：
//如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对总数。
public class P249_InversePairs_review {
    private static int count=0 ;
    public static int inversePairs(int[] data){
        if(data.length < 2 || data == null){
            return 0;
        }
        mergeSortCore(data,0,data.length-1);
        return count;
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
        int[] temp = new int[end - start + 1];//temp数组用于暂存合并的结果
        int left = start, right = mid + 1, tempIndex = 0;//左右半边的指针，合并后数组的指针
        while(left <= mid && right <= end){ // 合并两个有序数组：把较小的数先移到新数组中
            if(data[left] <= data[right]){
                temp[tempIndex++] = data[left++];
            } else {
                temp[tempIndex++] = data[right++];
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                count = (count + (mid - left + 1)) % 1000000007;
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while(left <= mid) { // 把左边剩余的数移入数组
            temp[tempIndex++] = data[left++];
        }
        while (right <= end) {// 把右边边剩余的数移入数组
            temp[tempIndex++] = data[right++];
        }
        for(int i = 0; i < temp.length; i++) {  // **把新数组中的数覆盖nums数组
            data[start + i] = temp[i];
        }
    }
    public static void main(String[] args){
        System.out.println(inversePairs(new int[]{7,5,6,4}));
    }
}
