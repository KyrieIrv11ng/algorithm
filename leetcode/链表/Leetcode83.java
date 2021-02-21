package leetcode.链表;

import leetcode.ListNode;

public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            if(slow.val==fast.val){
                fast = fast.next;
                slow.next = fast;
            }else{
                slow=slow.next;
                fast=fast.next;
            }

        }
        return head;
    }
}
