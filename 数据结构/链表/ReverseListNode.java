package 数据结构.链表;

import java.util.Stack;

public class ReverseListNode {
    //方法1.原地翻转 时间复杂度O(n) 空间复杂度
    public ListNode reverse1(ListNode head){
        if(head == null ||head.next ==null){
            return head;
        }

        ListNode l0 = head;
        ListNode l1 = head.next;
        ListNode l2 = head.next.next;
        while(l2!=null){
            l1.next = l0;
            l0 = l1;
            l1 = l2;
            l2 = l2.next;
        }
        l1.next = l0; //翻转最后一个
        head.next = null;//让头结点指向null 翻转完毕
        return l1;
    }
    //用栈来储存
    public ListNode reverse2(ListNode head){
        Stack<ListNode> s = new Stack<>();
        while(head!=null){
            s.push(head);
            head = head.next;
        }
        ListNode cur = s.pop();
        ListNode head1 = cur;
        while(!s.isEmpty()){
            cur.next = s.pop();
            cur = cur.next;
        }
        cur.next = null;
        return head1;
    }
    //类似于尾插法
    public ListNode reverse3(ListNode head){
        ListNode newNode = null;
        while(head!=null){
            ListNode temp = head.next; //记录他下一个节点
            head.next = newNode;//将当前节点连接到之前的节点上
            newNode = head;//指针向后移一个
            head = temp;
        }
        return newNode;
    }

}
