package leetcode;

public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            if(slow.val==fast.val){ //值相等，直接fast指向下一个，slow指针指向fast
                fast = fast.next;
                slow.next = fast;
            }else{
                slow=slow.next;     //不相等就一起前进
                fast=fast.next;
            }

        }
        return head;
    }
}
