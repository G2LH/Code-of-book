package List;
//如何k个一组反转链表
public class List_ReverseKth {
    public static ListNode Reversekth(ListNode head, int k){
        if(k == 1 || head == null){
            return head;
        }
        ListNode left=head,right=head;
        for(int i=0; i<k; i++){
            if(right == null){
                return head;
            }
            right = right.next;
        }
        ListNode phead = reverse(left,right);
        left.next = Reversekth(right,k);
        return phead;
    }
    public static ListNode reverse(ListNode left,ListNode right){
        ListNode pre = null, cur = left, post = cur;
        while(post != right){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}
