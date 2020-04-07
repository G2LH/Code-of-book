package String;
//最长回文串
public class String_LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s==null || s.length()<1){
            return s;
        }
        String res = s.substring(0,1);
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = PalindDrome(s,i,i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = PalindDrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            String maxLenStr = s1.length() > s2.length() ? s1 : s2;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    public static String LongestPalindrome(String s) {
        String res = "";
        for(int i =0; i < s.length();i++){
            String s1 = PalindDrome(s,i,i);
            String s2 = PalindDrome(s,i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    public static String PalindDrome(String s, int l,int r){
        while(l>=0&&r<s.length()&&s.charAt(l) == s.charAt(r)){
                l--;
                r++;
        }
        return s.substring(l+1,r);//(0,1)截取第一个字符
    }
    public static void main(String[] args){
        String s = "aba";
        System.out.print(LongestPalindrome(s));
    }
}
