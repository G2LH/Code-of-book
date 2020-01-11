package String;

/**
 * 替换空格
 * 把传入字符数组中的' '换成'&20',且传入数组保证有足够空间容纳修改后的字符
 */
public class String_P51_ReplaceSpaces {
    //由于java的字符数组没有结束符，所以需要多传入个原始长度
    //双指针：先计算好替换后的位置，从后向前替换，时间复杂度o(n)
    public static void replaceBlank(char[] data, int length){
        int newLength = length;
        for(int i = 0; i < length; i++){
            if(data[i] == ' ')
                newLength += 2;
        }
        int indexOfold = length - 1;
        int indexOfnew = newLength - 1;
        for(;indexOfold >= 0 && indexOfold != indexOfnew; indexOfnew--, indexOfold--){
            if(data[indexOfold] != ' ')
                data[indexOfnew] = data[indexOfold];
            else {
                data[indexOfnew--] = '0';
                data[indexOfnew--] = '2';
                data[indexOfnew] = '%';
            }
        }
    }
    public static void main(String[] args){
        char[] predata = "We are happy.".toCharArray();
        System.out.println(predata);
        // 防止data[indexOfnew]越界
        char[] data = new char[20];
        for(int i=0;i<predata.length;i++)
            data[i] = predata[i];
        replaceBlank(data,predata.length);
        System.out.println(data);
    }
}
