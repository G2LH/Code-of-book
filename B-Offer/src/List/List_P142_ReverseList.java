package List;

//反转链表
public class List_P142_ReverseList {
    public static ListNode<Integer> reverseList(ListNode<Integer> head){
        if(head == null || head.next == null)
            return null;
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post =cur.next;
        while (cur != null){
            cur.next = pre;

            //保持链表状态
            pre = cur;
            cur = post;
            if(post != null){
                post = post.next;
            }
        }
        return pre;
    }
    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(head);
        head = reverseList(head);
        System.out.println(head);
    }
}
