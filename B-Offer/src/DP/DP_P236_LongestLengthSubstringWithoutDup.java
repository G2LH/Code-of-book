package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：
import java.util.HashSet;

//最长不含重复字符的子字符串的长度
//题目要求：
//输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
public class DP_P236_LongestLengthSubstringWithoutDup {
    //HashSet
    public static int LongestSubString(String str){
        int l=0,r=0;
        int max=0,length=0;
        HashSet<Character> set = new HashSet<>();
        while(l<str.length()&&r<str.length()){
            if(!set.contains(str.charAt(r))){
                set.add(str.charAt(r));
                length=r-l+1;
                r++;
            }
            else{
                set.remove(str.charAt(l));//一直删到不重复为止
                l++;
            }
            if(max < length){
                max = length;
            }
        }
        return max;
    }

    //动态
    public static int longestSubstringWithoutDuplication(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int curLength = 0;
        int maxLength = 0;
        int[] pos = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            pos[i] = -1;
        }
        for(int i = 0; i < str.length(); i++){
            int preIndex = pos[str.charAt(i)-'a'];
            int distance  = i - preIndex;
            //如果当前字符没有出现过，或者出现后的d大于当前最长字串长度
            if(preIndex<0 || distance>curLength) {
                curLength++;
            }else{
                //如果d<=当前最长字串长度，说明两个相同字符在最长字串中
                if(curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = distance;
            }
            pos[str.charAt(i)-'a'] = i; //更新当前字符出现的位置
        }
        if(curLength>maxLength) {
            maxLength = curLength;
        }
        return maxLength;
    }
    public static void main(String[] args){
        System.out.println(longestSubstringWithoutDuplication("arabcacfr"));
        System.out.println(longestSubstringWithoutDuplication("abcdefaaa"));
    }
}
