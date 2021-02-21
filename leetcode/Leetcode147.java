package leetcode;

public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;        //定义当前节点前结点
        ListNode cur = head.next;   //定义当前节点
        while(cur!=null){
            if(cur.val>pre.val){    //当前节点大于之前节点，排好序了以及
                pre = cur;
                cur = cur.next;
            }else{
                ListNode p = dummy;     //否则，从头开始遍历
                while(p.next!=null&&p.next.val<cur.val){            //如果小于当前节点就一直向后遍历
                    p = p.next;
                }
                ListNode next = cur.next;           //交换结点
                cur.next = p.next;
                pre.next = next;
                p.next = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
}
