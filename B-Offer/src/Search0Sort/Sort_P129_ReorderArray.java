package Search0Sort;

//调整数组顺序使奇数位于偶数前面
public class Sort_P129_ReorderArray {
    public static void reorder(int[] data){
        if(data == null || data.length < 2)
            return;
        int left = 0;
        int right = data.length - 1;
        while(left < right){
            while(left < right && data[left]%2 != 0){
                left++;
            }
            while(left < right && data[right]%2 == 0){
                right--;
            }
            if(left < right){
                int temp = data[right];
                data[right] = data[left];
                data[left] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[] data = {1,2,3,4,5,7,7};
        reorder(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}
