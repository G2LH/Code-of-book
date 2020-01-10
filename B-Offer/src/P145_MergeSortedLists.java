//输入两个递增排序的链表，要求合并后保持递增。
public class P145_MergeSortedLists {
    public static ListNode<Integer> merge(ListNode<Integer> pHead1, ListNode<Integer> pHead2){
        if(pHead1 == null) {
            return pHead2;
        }
        if(pHead2 == null) {
            return pHead1;
        }
        ListNode<Integer> mHead;
        ListNode<Integer> head;
        if(pHead1.val < pHead2.val){
            mHead = pHead1;
            pHead1 = pHead1.next;
        }
        else{
            mHead = pHead2;
            pHead2 = pHead2.next;
        }
        head = mHead;
        while(pHead1 != null && pHead2 != null){
            if(pHead1.val < pHead2.val){
                mHead.next = pHead1;
                mHead = mHead.next;
                pHead1 = pHead1.next;
            }
            else{
                mHead.next = pHead2;
                mHead = mHead.next;
                pHead2 = pHead2.next;
            }
        }
        if(pHead1 != null){
            mHead.next = pHead1;
        }
        else{
            mHead.next = pHead2;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next= new ListNode<>(3);
        head1.next.next = new ListNode<>(5);
        head1.next.next.next = new ListNode<>(7);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next= new ListNode<>(4);
        head2.next.next = new ListNode<>(6);
        head2.next.next.next = new ListNode<>(8);
        System.out.println(head1);
        System.out.println(head2);
        System.out.println(merge(head1,head2));
    }
}
