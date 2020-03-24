package String;

import java.util.HashMap;
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串
public class String_ConstructLongestPalindrome {
    //注意：
    //如果某字母有偶数个，因为偶数有对称性，可以把它全部用来构造回文串；但如果是奇数个的话，并不是完全不可以用来构建，也不是只能选最长的那个，而是只要砍掉1个，剩下的变成偶数就可以全部计入了
    //但奇数字母里，可以保留1个不砍，把它作为回文串的中心，所以最后还要再加回一个1
        public int longestPalindrome(String s) {
            if(s == null){
                return 0;
            }
            if(s.length() == 1){
                return 1;
            }
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),1);
                }else{
                    map.put(s.charAt(i),1+map.get(s.charAt(i)));
                }
            }
            int length = 0;
            int odd = 0;
            for(char key:map.keySet()){
                if(map.get(key)%2 == 0){
                    length+=map.get(key);
                }
                if(map.get(key)%2 == 1){
                    length+=map.get(key)-1;
                    odd = 1;
                }
            }
            return length+odd;
        }
}
