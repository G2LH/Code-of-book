package List;
//去除有序数组或链表中重复的数字:双指针
public class List_RemoveDuplicate {
    public static ListNode RemoveDuplicate(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slow = head, fast = slow.next;
        while(fast!=null){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }else{
                fast = fast.next;
            }
        }
        slow.next=null;
        return head;
    }
//    int removeDuplicates(int[] nums) {
//        int n = nums.length;
//        if (n == 0) return 0;
//        int slow = 0, fast = 1;
//        while (fast < n) {
//            if (nums[fast] != nums[slow]) {
//                slow++;
//                // 维护 nums[0..slow] 无重复
//                nums[slow] = nums[fast];
//            }
//            fast++;
//        }
//        // 长度为索引 + 1
//        return slow + 1;
//    }
}
