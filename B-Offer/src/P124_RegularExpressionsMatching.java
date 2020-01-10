//实现正则表达式中.和*的功能。.表示任意一个字符，*表示他前面的字符的任意次（含0次）。(字符串与模式长度相等)
// 比如aaa与a.a和ab*ac*a匹配，但与aa.a和ab*a不匹配。
public class P124_RegularExpressionsMatching {
    public static boolean match(String str, String pattern){
        if(str == null || pattern ==null)
            return false;
        return matchCore(new StringBuilder(str), 0, new StringBuilder(pattern), 0);
    }
    public static boolean matchCore(StringBuilder str, Integer strIndex, StringBuilder pattern, Integer patternIndex){
        //有效性检验：str到尾，pattern到尾，匹配成功
        if(strIndex == str.length() && patternIndex == pattern.length()){
            return true;
        }
        //pattern先到尾，匹配失败
        if(strIndex != str.length() && patternIndex == pattern.length()){
            return false;
        }

        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*'){
            if ((strIndex != str.length() && pattern.charAt(patternIndex) == str.charAt(strIndex)) || (pattern.charAt(patternIndex) == '.' && strIndex != str.length())){
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex+1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex+1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            }
            else{
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length() && pattern.charAt(patternIndex) == str.charAt(strIndex)) || (pattern.charAt(patternIndex) == '.' && strIndex != str.length())){
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        else {
            return false;
        }
    }

    public static void main(String[] args){
        System.out.print(match("aaa", "a.a"));
        System.out.println(match("aaa","ab*ac*a"));//true
        System.out.println(match("aaa","aa.a"));//false
        System.out.println(match("aaa","ab*a"));//false
    }
}
