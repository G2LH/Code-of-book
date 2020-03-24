package DP;
////状态定义：
////转移方程：
////初始状态：
////返回值：

//动态规划：给你一根长度为n的绳子，请把绳子剪成m段，求每段绳子的乘积最大
//剪了一刀后,f(n)=max(f(i)*f(n-i))
public class DP_P96_CuttingRope {
    public static int maxCutting(int length){
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;
        int[] rope = new int[length + 1];
        rope[0] = 0;
        rope[1] = 1;
        rope[2] = 2;
        rope[3] = 3;
        //其实是从product[4]开始算，这里是为了计算，当输入0 1 2 3时，前面已经处理
        int max = 0;
        int temp = 0;
        for(int i=4; i<=length;i++){
            max=0;
            //因为要计算f(j)乘以f(i-j)的最大值,j超过i的一半时是重复计算
            for(int j=1;j<=i/2;j++){
                temp = rope[j]*rope[i-j];
                if(max<temp)
                    max=temp;
            }
            rope[i]=max;//存储已经求过得解
        }
        return rope[length];
    }
    public static void main(String[] args){
        for(int i=2;i<10;i++){
            System.out.println("长度为"+i+"的最大值->"+maxCutting(i));
        }
    }
}
