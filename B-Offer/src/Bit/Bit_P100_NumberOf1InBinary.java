package Bit;

public class Bit_P100_NumberOf1InBinary {
    //将数字无符号右移。循环32次
    public static int NumberOf1(int n){
        int count = 0;
        while(n!=0){
            if((n&1)!=0)
                count++;
            n>>>=1;
        }
        return count;
    }
    //标记左移，使用一个标记，初始为1，让标记值与原输入数字异或，然后标记值左移。循环32次
    public static int NumberOf2(int n){
        int count = 0;
        int flag = 0;
        while(flag!=0){
            if((n&flag)!=0)
                count++;
            flag<<=1;
        }
        return count;
    }
    //二进制数有如下结论：
    //把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把原整数的二进制表示形式的最右边的1变成0
    //循环次数 为1的次数
    public static int NumberOf3(int n){
        int count=0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(NumberOf1(3));
        System.out.println(NumberOf1(-3));
        System.out.println(NumberOf2(3));
        System.out.println(NumberOf2(-3));
        System.out.println(NumberOf3(3));
        System.out.println(NumberOf3(-3));
    }
}
