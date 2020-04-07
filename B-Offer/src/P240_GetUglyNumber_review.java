//丑数:题目要求：
//我们把只包含因子2,3,5的数成为丑数。求按照从小到大的顺序第1500个丑数。1作为第一个丑数。
public class P240_GetUglyNumber_review {
    //空间换时间
    public static int GetUglyNumber(int n){
        int index = 0;
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int n2 = 0,n3=0,n5=0;
        while(index+1<n){
            uglyNum[++index] = min(uglyNum[n2]*2,uglyNum[n3]*3,uglyNum[n5]*5);
            //2*3=6，3*2=6，会有重复值，因此下面需要使用if，而不能用if-else
            if(uglyNum[n2]*2==uglyNum[index])
                n2++;
            if(uglyNum[n3]*3==uglyNum[index])
                n3++;
            if(uglyNum[n5]*5==uglyNum[index])
                n5++;
        }
        return uglyNum[n-1];
    }
    public static int min(int x,int y,int z){
        int temp = x<y?x:y;
        return temp<z?temp:z;
    }
    public static boolean isUgly(int number){
        while (number%2==0)
            number/=2;
        while (number%3==0)
            number/=3;
        while (number%5==0)
            number/=5;
        return number==1;
    }
    public static void main(String[] args){
        System.out.println(GetUglyNumber(10));
    }
}
