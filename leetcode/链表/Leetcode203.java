package leetcode.链表;

import leetcode.ListNode;

public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode pre = newNode;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                cur = cur.next;
                pre = pre.next;
            }
        }
        return newNode.next;
    }
}
