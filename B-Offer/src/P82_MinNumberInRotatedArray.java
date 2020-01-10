// 旋转数组的最小数字
//原本有序，进行了旋转，但在一定程度上还是有序的,二分查找
public class P82_MinNumberInRotatedArray {
    public static int min(int[] data){
        if(data==null || data.length==0)
            return -1;
        int left = 0;
        int right = data.length-1;
        int mid = left;//旋转数组是原数组本身，返回第一个值
        while(data[left] >= data[right]){
            if(right-left==1){
                mid = right;
                break;
            }
            mid = (left + right)/2;
            //无法判断mid位于前后哪个数组
            if(data[left]==data[mid] && data[right]==data[mid]){
                int result = data[left];
                for(int i=left+1;i<=right;i++){
                    if(result>data[i])
                        result=data[i];
                }
                return result;
            }
            if(data[mid]>data[left])
                left = mid;
            else if(data[mid]<data[right])
                right = mid;

        }
        return data[mid];
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
