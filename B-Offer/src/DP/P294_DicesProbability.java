package DP;

public class P294_DicesProbability {
    //1.动态规划
    public static void printProbability(int number){
        if(number<=0) {
            return;
        }
        //dp[i][j] 表示前 i 个骰子产生点数 j 的次数
        int result[][] = new int[number + 1][6*number+1];
        for(int i=1;i<=6;i++) {
            result[1][i] = 1;
        }
        //f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)
        for (int i=2;i<=number;i++){
            for(int j=i;j<=6*i;j++){//i个骰子 最大和为6*i
                for(int k=1;k<=6 && k <= j;k++)
                        result[i][j] += result[i-1][j-k];
            }
        }
        double sum = 0;
        for(int i=number;i<=6*number;i++)
            sum += result[number][i];
        System.out.println("number = "+number);
        for(int i=number;i<=6*number;i++)
            System.out.println("probability "+i+":"+result[number][i]/sum);
    }
    //2.递归
    public static int getNSumCount(int n, int sum)
    {
        if(n<1||sum<n||sum>6*n)
        {
            return 0;
        }
        if(n==1)
        {
            return  1;
        }
        int resCount=0;
        resCount=getNSumCount(n-1,sum-1)+getNSumCount(n-1,sum-2)+
                getNSumCount(n-1,sum-3)+getNSumCount(n-1,sum-4)+
                getNSumCount(n-1,sum-5)+getNSumCount(n-1,sum-6);
        return resCount;
    }

    public static void main(String[] args){
        printProbability(2);
        printProbability(0);
        printProbability(11);
    }
}
