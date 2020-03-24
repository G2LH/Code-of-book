//二分查找
public class ShipWithDay {
    // 寻找左侧边界的二分查找
    public static int shipWithinDays(int[] weights, int D) {
        // 载重可能的最小值
        int left = getMax(weights);
        // 载重可能的最大值 + 1
        int right = getSum(weights) + 1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(canFinish(weights,D,mid)){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;
    }
    public static boolean canFinish(int[] weights, int D, int cap){
        int index = 0;
        for(int day = 0; day < D; day++){
            int maxCap = cap;
            while ((maxCap -= weights[index]) >= 0) {
                index++;
                if (index == weights.length) {
                    return true;
                }
        }
        }
        return false;
    }
    public static int getMax(int[] weights){
        int max = 0;
        for(int n:weights){
            max = Math.max(n,max);
        }
        return max;
    }
    public static int getSum(int[] weights){
        int max = 0;
        for(int n:weights){
            max+=n;
        }
        return max;
    }
}
