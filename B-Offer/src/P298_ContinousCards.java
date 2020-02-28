import java.util.Arrays;

public class P298_ContinousCards {
    public static boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length <= 0){
            return false;
        }
        Arrays.sort(numbers);
        int num0 = 0, num = 0, j;
        for(int i = 0; i < numbers.length-1; i++){
            if(numbers[i] == 0){
                num0++;
                continue;
            }
            if(numbers[i+1] == numbers[i]){
                return false;
            }
            if(numbers[i+1] - numbers[i] > 1){
                num += (numbers[i+1]-numbers[i]-1);//要计算数间的差值
            }
        }
        if(num <= num0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        int[] data1 = new int[]{4,2,7,12,1}; //false
        int[] data2 = new int[]{0,5,6,12,0}; //false
        int[] data3 = new int[]{1,3,0,5,0};  //true
        int[] data4 = new int[]{0,5,6,9,8};  //true
        int[] data5 = new int[]{0,13,0,12,0}; //true
        //System.out.println(isContinuous(data1));
        //System.out.println(isContinuous(data2));
        System.out.println(isContinuous(data3));
        //System.out.println(isContinuous(data4));
        //System.out.println(isContinuous(data5));
    }

}
