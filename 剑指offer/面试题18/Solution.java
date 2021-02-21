package 剑指offer.面试题18;

import leetcode.ListNode;

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
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
