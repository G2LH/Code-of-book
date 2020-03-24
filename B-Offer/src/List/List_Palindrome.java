package List;

public class List_Palindrome {
    //
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            ListNode oldCur = slow;
            slow = slow.next;
            fast = fast.next.next;//fast到尾,slow到中间了
            oldCur.next = prev;
            prev = oldCur;
        }

        if (fast != null) {
            // 链表个数为奇数
            slow = slow.next;
        }

        // 判断pre和slow是否相等
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
