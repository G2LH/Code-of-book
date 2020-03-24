//1~n整数中1出现的次数
//题目要求：
//输入一个整数，求1~n这n个整数中1出现的次数。如输入12，则包含1的数字有1,10,11,12，一共出现了5次1，因此输入5。
public class P221_NumberOf1 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            String s = String.valueOf(i);
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j)=='1'){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n =10;
        System.out.print(NumberOf1Between1AndN_Solution(n));
    }
}
