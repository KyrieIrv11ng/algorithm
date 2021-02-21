package leetcode;

public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode largeCur = large;
        ListNode smallCur = small;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                small.next = cur;
                small = small.next;
            }else{
                large.next = cur;
                large = large.next;
            }
            cur = cur.next;
        }
        if (large.next!=null){
            large.next=null;
        }else if(small.next!=null){
            small.next=null;
        }
        small.next = largeCur.next;
        return smallCur.next;
    }
}
