//在o(1)时间内删除单链表的节点。
public class P119_DeleteNodeInList {
    public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node){
        //删除头结点
        if(node == head){
            return head.next;
        }
        //将欲删节点的后一个节点的值拷贝到欲删节点之上，删除欲删节点的后一个节点
        else if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
            return head;
        }
        //删除尾节点
        else{
            ListNode<Integer> temp = head;
            while(temp != node){
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
    }
    public static ListNode<Integer> deleteDuplication(ListNode<Integer> head) {
        ListNode<Integer> temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args){
//        ListNode<Integer> head = new ListNode<>(1);
//        ListNode<Integer> node2 = new ListNode<>(2);
//        ListNode<Integer> node3 = new ListNode<>(3);
//        head.next = node2;
//        node2.next =node3;
//        System.out.print(head);
//        head = deleteNode(head, node3);
//        head = deleteNode(head, node2);
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next= new ListNode<Integer>(1);
        head.next.next = new ListNode<Integer>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        head.next.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);
    }
}
