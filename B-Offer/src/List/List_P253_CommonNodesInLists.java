package List;

import java.util.Stack;
//两个链表的第一个公共节点
//题目要求：
//输入两个单链表，找出它们的第一个公共节点。以下图为例，对一个公共节点为6所在的节点
public class List_P253_CommonNodesInLists {
    //从链表的尾部向前看，发现尾部是相同的，向前走会分叉，找到分叉点即可
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        for(ListNode node1 = pHead1; node1!=null; node1= node1.next){
            s1.push(node1);
        }
        for(ListNode node2 = pHead2; node2!=null; node2= node2.next){
            s2.push(node2);
        }
        ListNode tempNode = null;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek() == s2.peek()){
                tempNode = s1.pop();
                s2.pop();
            }else{
                break;
            }
        }
        return tempNode;
    }
    //一个麻烦点是两个链表长度可能不一致，因此两个指针不同步（指两个指针无法同时指向公共点）
    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode node1 = pHead1, node2 = pHead2;
        int size1 = 0, size2 = 0;
        for(;node1!=null;node1 = node1.next){
            size1++;
        }
        for(;node2!=null;node2=node2.next){
            size2++;
        }
        node1 = pHead1;
        node2 = pHead2;
        while(size1>size2){
            node1 = node1.next;
            size1--;
        }
        while(size1<size2){
            node2 = node2.next;
            size2--;
        }
        while (node1!=null){
            if(node1!=node2){
                node1 = node1.next;
                node2 = node2.next;
            }
            else {
                break;
            }
        }
        return node1;
    }
    public static void main(String[] args){
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode<Integer> commonNode = FindFirstCommonNode(node1,node4);
        System.out.println(commonNode.val);
    }
}
