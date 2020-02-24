package DP;

public class DP_P236_LongestSubstringWithoutDup {
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
