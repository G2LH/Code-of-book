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
