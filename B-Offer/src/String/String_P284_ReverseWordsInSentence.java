package String;

import java.util.Stack;

public class String_P284_ReverseWordsInSentence {
    //1.Stack
    public static String ReverseSentence(String str) {
        if(str == null){
            return null;
        }
        Stack<String> s = new Stack<>();
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                strB.append(str.charAt(i));
            }
            if(str.charAt(i) == ' ' || i == str.length() - 1){
                s.push(strB.toString());
                strB = new StringBuilder();
            }
        }
        while(!s.isEmpty()){
            strB.append(s.pop());
            strB.append(' ');
        }
        strB.deleteCharAt(strB.length()-1);
        return strB.toString();
    }
    //2.先整体 再各部分
    public static String ReverseSentence1(String str) {
        if (str == null || str.trim().length() == 0) return str;
        char[] chars = str.toCharArray();
        reverseChars(chars, 0, str.length() - 1);
        // 遇到' '执行翻转
        int left = 0;
        int right = 0;
        while (left < str.length()) {
            if (chars[right] == ' ') {
                reverseChars(chars, left, right - 1);
                // 交换完之后,一起跳过' '
                right++;
                left = right;
            }
            if (right == str.length() - 1) {
                reverseChars(chars, left, right);
                // 到了最后交换玩就break，否则r会出现越界，可以在while中加对r的判断
                break;
            }
            right++;
        }
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
        System.out.println(ReverseSentence1("I am a student."));
    }
}
