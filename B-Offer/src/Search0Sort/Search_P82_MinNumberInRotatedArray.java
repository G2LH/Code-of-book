package Search0Sort;

// 旋转数组的最小数字
//原本有序，进行了旋转，但在一定程度上还是有序的,二分查找
public class Search_P82_MinNumberInRotatedArray {
    public static int min(int[] numbers){
        if(numbers==null || numbers.length==0)
            return -1;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
                int m = (i + j) / 2;
                if (numbers[m] > numbers[j]) i = m + 1;
                else if (numbers[m] < numbers[j]) j = m;
                else j--;//numbers[mid] == numbers[right]
        }
        return numbers[i];
    }
    public static void main(String[] args){
        int[] data1 = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        int[] data3 = {1,1,1,0,1};
        System.out.println(min(data1));
        System.out.println(min(data2));
        System.out.println(min(data3));
    }
}
