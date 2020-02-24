public class P275_FindNumberApperanceOnce {
    //problem
    public static int FindNumsAppearOnce(int[] array) {

        //处理异常情况
        if (array == null || array.length <= 0)
        {
            return -1;
        }
        //定义一个数组存放数组各元素二进制各位上的值的和
        int[] bitarr = new int[32];
        for(int i=0;i<32;i++) {
            bitarr[i] = 0;
        }
        //遍历整个数组，计算数组各元素在各位上的和,计算各位的1的个数
        for (int i = 0; i < array.length; i++)
        {
            int bitmask = 1;//位掩码
            for (int j = 31; j >= 0; j--)
            {
                int bit = array[i] & bitmask;
                if (bit != 0)
                {
                    bitarr[j] += 1;
                }
                bitmask = bitmask << 1;
            }
        }
        //用数组各元素各位上的和除以3，记录不被3整除的数
        int result = 0;
        for (int k = 0; k < 32; k++)
        {
            result = result << 1;
            result += bitarr[k] % 3;
        }
        return result;
    }
    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        System.out.print(FindNumsAppearOnce(data)); // 4,6
    }
}
