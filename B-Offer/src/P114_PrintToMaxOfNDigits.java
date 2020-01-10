//打印从1到最大的n位数
//大数问题
public class P114_PrintToMaxOfNDigits {
    public static void printToMaxOfNDigits(int num){
        if(num < 0)
            return;
        StringBuilder number = new StringBuilder(num);
        for(int i = 0; i < num; i++){
            number.append('0');
        }
        while(increment(number)){
            printNumber(number);
        }
    }
    //加1
    public static  boolean increment(StringBuilder str){
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) < '9' && str.charAt(i) >= '0'){
                str.setCharAt(i, (char)(str.charAt(i) + 1));
                return true;
            }
            else if(str.charAt(i) == '9'){
                str.setCharAt(i, '0');
            }
            else{
                return false;
            }
        }
        return false;
    }
    //字符串的首0不打印
    public static void printNumber(StringBuilder number){
        boolean flag = false;
        for(int i = 0; i < number.length(); i++){
            if(flag)
                System.out.print(number.charAt(i));
            else{
                if(number.charAt(i) != '0'){
                    flag = true;
                    System.out.print((number.charAt(i)));
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        printToMaxOfNDigits(2);
    }
}
