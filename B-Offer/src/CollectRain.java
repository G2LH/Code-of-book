//收集雨水问题：min(l[i],r[i])-height[i]
public class CollectRain {
    public static int trap(int[] height) {
        int res = 0;
        int[] lmax = new int[height.length];
        int[] rmax = new int[height.length];
        lmax[0] = height[0];
        rmax[0] = height[height.length-1];
        for(int i = 1; i < height.length; i++){
            lmax[i] = Math.max(height[i],lmax[i-1]);
        }
        for(int i =height.length-2; i >0; i--){
            rmax[i] = Math.max(height[i],rmax[i-1]);
        }
        for(int i = 1; i < height.length-1; i++){
            res+=Math.min(lmax[i],rmax[i]) - height[i];
        }
        return res;
    }

//    int n = height.size();
//    int ans = 0;
//    for (int i = 1; i < n - 1; i++) {
//        int l_max = 0, r_max = 0;
//        // 找右边最高的柱子
//        for (int j = i; j < n; j++)
//            r_max = max(r_max, height[j]);
//        // 找左边最高的柱子
//        for (int j = i; j >= 0; j--)
//            l_max = max(l_max, height[j]);
//        // 如果自己就是最高的话，
//        // l_max == r_max == height[i]
//        ans += min(l_max, r_max) - height[i];
//    }
//    return ans;
}
