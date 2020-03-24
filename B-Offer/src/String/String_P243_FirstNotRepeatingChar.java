package String;
//第一个只出现一次的字符
//题目要求：
//字符串中第一个只出现一次的字符。在字符串中找出第一个只出现一次的字符。如输入abaccdeff，则输出b。
import java.util.HashMap;
import java.util.LinkedHashMap;

public class String_P243_FirstNotRepeatingChar {
    //LinkedHashMap返回第一个字符
    public static char firstNotRepeatingChar(String str){
        if(str == null||str.length()==0){
            return ' ';
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();//有序遍历
        int count;
        for(int i = 0; i < str.length(); i++){
            count = 1;
            if(map.containsKey(str.charAt(i))){
                count = map.get(str.charAt(i))+1;
            }
            map.put(str.charAt(i),count);
        }
        for(char key : map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }
        return '#';
    }

    //返回下标 HashMap
    public static int firstNotRepeatingChar2(String str){
        if(str == null || str.length() < 0 || str.length()>10000){
            return -1;
        }
        HashMap<Character,Integer> mapC = new HashMap<>();
        int count;
        for(int i = 0; i < str.length(); i++){
            count = 1;
            if(mapC.containsKey(str.charAt(i))){
                count = mapC.get(str.charAt(i))+1;
            }
            mapC.put(str.charAt(i),count);
        }
        for(int i = 0; i < str.length();i++){
            if(mapC.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
    //返回下标 ASCII值
    public static int FirstNotRepeatingChar3(String str) {
        if(str==null || str.length() == 0)return -1;
        int[] count = new int[256];
        //用一个类似hash的东西来存储字符出现的次数，很方便
        for(int i=0; i < str.length();i++)
            count[str.charAt(i)]++;
        //其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
        for(int i=0; i < str.length();i++)
            if(count[str.charAt(i)]==1)
                return i;
        return -1;
    }
    public static void main(String[] args){
        //System.out.println(firstNotRepeatingChar("abaccdeff"));
        System.out.println(firstNotRepeatingChar2("google"));

    }
}
