package leetcode.链表;

import leetcode.ListNode;

public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = n;i > 0;i--){
            fast = fast.next;
        }
        while(fast!=null){
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if(pre==slow){
            return pre.next;
        }else{
            pre.next = pre.next.next;
            return head;
        }
    }
}
