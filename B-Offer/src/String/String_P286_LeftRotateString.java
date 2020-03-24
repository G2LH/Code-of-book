package String;
//左旋转字符串
//
//题目要求：
//实现一个函数完成字符串的左旋转功能。比如，输入abcdefg和数字2，输出为cdefgab。
//还是先整体 后部分
public class String_P286_LeftRotateString {
    public static String ReverseSentence(String str,int n) {
        if (str == null || str.trim().length() == 0 || n == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, str.length() - 1);
        reverseChars(chars, 0, str.length() - 1 - n);
        reverseChars(chars, str.length() - n, str.length() - 1);
        return String.valueOf(chars);
    }
    private static void reverseChars(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        System.out.println(ReverseSentence("abdhfg",2));
    }
}
