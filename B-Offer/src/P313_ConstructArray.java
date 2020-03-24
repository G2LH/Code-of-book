public class P313_ConstructArray {
    //构建乘积数组:给定数组A[0,1...n-1]，求B[0,1...n-1]，要求B[i] = A[0]*A[1]...A[i-1]*A[i+1]...A[n-1]，不能使用除法。
    //1
    public static int[] multiply(int[] A){
        if(A==null||A.length<2)
            return null;
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            int temp = A[i];//当前赋值为1，以后需要复原
            A[i] = 1;
            B[i] = 1;
            for(int j = 0; j < A.length; j++){
                B[i] *= A[j];
            }
            A[i] = temp;
        }
        return B;
    }
    //2.上下三角
    public static int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        //边界
        if (A == null || A.length <= 1) {
            return null;
        }
        //计算下三角
        //初始化第一行
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        //计算上三角
        //初始化最后一行
        int temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            B[i] = temp * B[i];
            temp = A[i] * temp;
        }
        return B;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        int[] result = multiply(data);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("  ");
        }
    }
}
