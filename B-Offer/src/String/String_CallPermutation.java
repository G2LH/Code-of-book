package String;
import java.util.ArrayList;
import java.util.List;
//回溯排列组合：
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母

//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
public class String_CallPermutation {
        private String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };
        private ArrayList<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0){
                return new ArrayList<>();
            }
            StringBuilder ans = new StringBuilder();
            backtrack(digits,0,ans);
            return res;
        }
        public void backtrack(String digits, int index, StringBuilder ans){
            if(index == digits.length()){
                res.add(new String(ans.toString()));
                return;
            }
            char id = digits.charAt(index);
            String str = letterMap[id-'0'];
            for(int i=0; i<str.length(); i++){
                ans.append(str.charAt(i));
                backtrack(digits,index+1,ans);
                ans.deleteCharAt(ans.length()-1);
            }
        }
}
