package leetcode;

public class Leetcode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode l0 = new ListNode(0);      //创建一个头结点
        l0.next = head;
        ListNode pre = l0;
        for(int i = 1;i<m;i++){
            pre = pre.next;         //找到翻转结点的前一个结点
        }
        ListNode start = pre;       //等会连接使用
        ListNode cur = pre.next;        //翻转结点的第一个结点
        for(int i = 0;i<(n-m+1);i++){       //翻转
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        start.next.next = cur;  //连接链表
        start.next = pre;
        return l0.next;
    }
}
