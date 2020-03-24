import java.util.HashMap;
//题目要求：
//一个整数数组里除了两个数字出现一次，其他数字都出现两次。请找出这两个数字。要求时间复杂度为o(n)，空间复杂度为o(1)。
public class P275_NumberAppearOnce {
    private static int num1 = 0,num2=0;
    //1.
    public static void FindNumsAppearOnce(int[] array) {
        int xor1 = 0;
        for(int i=0; i < array.length; i++) {
            xor1 = xor1 ^ array[i];
        }
        int index = 1;//在xor1中找到第一个不同的位对数据进行分类，分类为两个队列对数据进行异或求和找到我们想要的结果
        while((index & xor1)==0) {
            index = index << 1;//因为可能有多个位为1所以需要求一下位置
        }
        int result1 = 0;
        int result2 = 0;
        for(int i=0; i < array.length; i++){
            if((index & array[i]) == 0)
                result1 = result1^array[i];
            else
                result2 = result2^array[i];
        }
        num1 = result1;
        num2 = result2;
    }
    //2.hash
    public static void FindNumsAppearOnce2(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i],2);
            }
            else{
                map.put(array[i],1);
            }
        }
        int count = 0;
        for(int i=0; i < array.length; i++){
            if(map.get(array[i]) == 1){
                if(count == 0){
                    num1 =  array[i];
                    count++;
                }else{
                    num2 =  array[i];
                }
            }
        }
    }
    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(data); // 4,6
        System.out.println(num1);
        System.out.println(num2);

    }
}
