//把数组排列成最小的数
//题目要求：
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，使其为所有可能的拼接结果中最小的一个
//对数组进行排序，组合后判断大小，排序(数字组合涉及到大数问题)
public class P227_SortArrayForMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0 || numbers == null){
            return "";
        }
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j <numbers.length; j++){
                int num1 = Integer.valueOf(numbers[i]+""+numbers[j]);
                int num2 = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(num1 >num2){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String num = String.valueOf(numbers[0]);
        for(int c = 1; c < numbers.length; c++){
            num += String.valueOf(numbers[c]);
        }
        return num;
    }
    public static void main(String[] args){
        int[] num = {21,3,213};
        System.out.print(PrintMinNumber(num));
    }
}
