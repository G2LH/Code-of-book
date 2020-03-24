package Stack0Queue;

import java.util.Stack;

//如何判定括号合法性:左括号入栈，右括号对比
public class Stack_KuoHao {
    public static boolean IsVaild(String str){
        if(str==null||str.length()==0){
            return false;
        }
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                s.push(str.charAt(i));
            }else{
//                if(str.charAt(i) == s.peek()&&!s.isEmpty()){
//                    s.pop();
//                }else{
//                    return false;
//                }
            }
        }
        return s.isEmpty();
    }
}
