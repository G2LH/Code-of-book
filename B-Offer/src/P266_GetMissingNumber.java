public class P266_GetMissingNumber {
    public static int getMissingNumber(int[] data){
        int left = 0, right = data.length - 1;
        int mid;
        while(left <= right){
            mid = (left + right)/2;
            if(data[mid] == mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return  left;
    }
    public static void main(String[] args){
        int[] data1 = new int[]{0,1,2,3,4,5}; //6
        int[] data2 = new int[]{0,1,3,4,5}; //2
        int[] data3 = new int[]{1,2}; //0
        System.out.println(getMissingNumber(data1));
        System.out.println(getMissingNumber(data2));
        System.out.println(getMissingNumber(data3));
    }
}
