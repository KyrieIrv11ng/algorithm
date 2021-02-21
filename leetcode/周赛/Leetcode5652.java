package leetcode.周赛;

import 数据结构.链表.ListNode;

public class Leetcode5652 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 0; i < k-1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode low = cur;
        ListNode tmp = cur;
        ListNode highPre = dummy;
        ListNode high = head;
        while(tmp.next!=null){
            highPre = highPre.next;
            tmp = tmp.next;
            high = high.next;
        }
        ListNode lowtmp = low.next;
        ListNode hightmp = high.next;
        if(low.next==high){
            low.next = hightmp;
            high.next = low;
            pre.next = high;
        }else if(high.next==low){
            low.next = high;
            high.next = lowtmp;
            highPre.next = low;
        }
        else{
            high.next = lowtmp;
            highPre.next = low;
            low.next = hightmp;
            pre.next = high;

        }
        return dummy.next;
    }
}
