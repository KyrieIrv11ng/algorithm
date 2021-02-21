package leetcode.链表;

import leetcode.ListNode;

public class Leetcode160 {
    //意思就是 A链表跑完在B上跑 B上跑完在A上跑，A+B = B+A
    // 如果A结点等于B结点 就说明有相同的结点（焦点）或者都到了null（A->B->null  B->A->null）
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=pB){
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;
        }
        return pA;
    }
}
