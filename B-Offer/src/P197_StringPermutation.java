import java.util.ArrayList;
import java.util.Collections;
//字符串的排列 组合
public class P197_StringPermutation {

    //排列:看成两部分，第一部分是第一个字符，第二部分是其它所有字符
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> resultList = new ArrayList<>();
        if (str.length() == 0) {
            return resultList;
        }
        //递归的初始值为（str数组，空的list，初始下标0
        PermutationHelp(str.toCharArray(), resultList, 0);
        Collections.sort(resultList);
        return resultList;
    }
    //对cha[i~length-1]范围内的字符数组完成全排列，并将结果加入res中
    public static void PermutationHelp(char[] str, ArrayList<String> list, int index) {
        if (index == str.length - 1 && !list.contains(new String(str))) {
            list.add(new String(str));
            return;
        }
        for(int i = index; i < str.length; i++){
            swap(str,index,i);
            PermutationHelp(str,list,index+1);
            swap(str,index,i);//恢复原数组
        }
    }
    //组合:我们可以把n个字符分成两部分，第一个字符和其他所有字符，
    public static ArrayList<String> Combination(String str) {
        ArrayList<String> resultList = new ArrayList<>();
        if (str.length() == 0) {
            return resultList;
        }
        StringBuilder strB = new StringBuilder();
        for(int i = 1; i <= str.length(); i++){
            CombinationHelp(str.toCharArray(), resultList,strB, 0, i);
        }
        return resultList;
    }

    public static void CombinationHelp(char[] str, ArrayList<String> list,StringBuilder strB, int begin, int num) {
        if (num == 0 && !list.contains(strB.toString())) {
            list.add(strB.toString());
            return;
        }
        if(begin >= str.length){
            return;
        }else {
            //把第一个字符放入组合中,在剩余的字符中选取num-1个字符
            strB.append(str[begin]);
            CombinationHelp(str,list,strB,begin+1,num-1);
            //组合里不包含第一个字符,则下一步在剩余的字符中选取num个字符
            strB.deleteCharAt(strB.length() - 1);
            CombinationHelp(str,list,strB,begin+1,num);
        }
    }
    private static void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    public static void main(String[] args) {
    String str = "abc";
   // ArrayList list = Permutation(str);
        ArrayList list = Combination(str);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
