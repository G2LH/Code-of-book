package Search0Sort;

//调整数组顺序使奇数位于偶数前面
public class Sort_P129_ReorderArray {
    public static void reorder(int[] array){
//        if(data == null || data.length < 2)
//            return;
//        int left = 0;
//        int right = data.length - 1;
//        while(left < right){
//            while(left < right && data[left]%2 != 0){
//                left++;
//            }
//            while(left < right && data[right]%2 == 0){
//                right--;
//            }
//            if(left < right){
//                int temp = data[right];
//                data[right] = data[left];
//                data[left] = temp;
//            }
//        }

        //保持相对位置
        int i=0;
        while(i<array.length){
            while(array[i]%2!=0){
                i++;
            }
            int j = i + 1;
            while(array[j]%2==0){
                j++;
                if(j>=array.length)
                    return;
            }
            for(int k = j; k > i;k--){
                int temp = array[k];
                array[k] = array[k-1];
                array[k-1] = temp;
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
