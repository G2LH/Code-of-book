package List;

import java.util.Stack;

public class List_P58_PrintListInReversedOrder {
    //递归
    public static void printReversingRecursive(ListNode<Integer> node){
        if(node == null)
            return;
        else{
            printReversingRecursive(node.next);
            System.out.println(node.val);
        }
    }
    //用栈非递归
    public static void printReversingIterative(ListNode<Integer> node){
        Stack<Integer> stack = new Stack<>();
        for(;node != null;node = node.next){
            stack.add(node.val);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        printReversingRecursive(head);
        printReversingIterative(head);
    }
}
