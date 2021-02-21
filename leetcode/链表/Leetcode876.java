package leetcode.链表;

import leetcode.ListNode;

public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
