package leetcode.链表;

import leetcode.ListNode;

public class Leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null||head.next.next==null){
            return head;
        }
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        int count = 0;
        while(head!=null){
            if(count%2==0){
               if(oddHead==null){
                   oddHead = head;
                   oddTail = head;
               }else{
                   oddTail.next = head;
                   oddTail = oddTail.next;
               }

            }else{
                if(evenHead==null){
                    evenHead = head;
                    evenTail = head;
                }else{
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            }
            head = head.next;
            count++;
        }
        oddTail.next = null;//防止链表成环
        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }
}
