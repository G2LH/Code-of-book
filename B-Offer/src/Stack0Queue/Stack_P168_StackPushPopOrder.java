package Stack0Queue;
//栈的压入弹出序列
//
//栈的压入弹出序列
//题目要求：输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序序列。假设压入栈的所有数字均不相等。
import java.util.Stack;

public class Stack_P168_StackPushPopOrder {
    public static boolean isPopOrder(int[] in, int[] out){
        if(in == null || out == null || in.length != out.length){
            return false;
        }
        Stack<Integer> temp = new Stack();
        int i = 0,j = 0;
        while(j < out.length){
            if(temp.isEmpty() || temp.peek() != out[j]){
                if(i < in.length){
                    temp.push(in[i++]);
                }
                else{
                    return false;
                }
            }
            else{
                temp.pop();
                j++;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] in = {1,2,3,4,5};
        int[] out = {5,4,3,1,2};
        System.out.print(isPopOrder(in,out));
    }
}
