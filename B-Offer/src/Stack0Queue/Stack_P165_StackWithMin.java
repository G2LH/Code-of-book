package Stack0Queue;
//包含min函数的栈
//
//题目要求：
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。要求在该栈中，调用min，push及pop的时间复杂度都是o(1)。
import java.util.Stack;

public class Stack_P165_StackWithMin {
    public static void main(String[] args){
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }
}
class StackWithMin<T extends Comparable>{
    private Stack<T> stack = new Stack<>();
    private Stack<T> min = new Stack<>();
    public void push(T data){
        stack.push(data);
        if(min.isEmpty()){
            min.push(data);
        }else{
            T temp = min.peek();
            if(temp.compareTo(data) < 0){
                min.push(temp);//不更新；当大数出栈时，其min栈也正常出栈，不影响其它；保持最小的一直在上面
            }else{
                min.push(data);
            }
        }
    }
    public T pop(){
        if(stack.isEmpty()){
            return null;
        }
        min.pop();
        return stack.pop();
    }
    public T min(){
        if(min.isEmpty()){
            return null;
        }
        return min.peek();
    }
}
