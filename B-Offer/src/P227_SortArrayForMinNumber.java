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
