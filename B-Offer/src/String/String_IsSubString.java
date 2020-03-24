package String;
//双指针
public class String_IsSubString {
    public static boolean IsSubString(String str1,String str2){
        if(str1 == str2){
            return true;
        }
        if(str1 == null || str2 == null){
            return false;
        }
        int i = 0, j = 0;
        while(i< str1.length()&&j<str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i==str1.length();
    }
}
