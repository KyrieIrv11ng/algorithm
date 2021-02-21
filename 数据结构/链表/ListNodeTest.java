package 数据结构.链表;

import org.junit.Test;

public class ListNodeTest {
    public static ListNode listNodeGenerate(){
        ListNode head = new ListNode(0);//
        ListNode cur = head;
        for (int i = 0; i < 10; i++) {
            cur.next = new ListNode((int) (Math.random()*10));
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }

    public static void listNodePrint(ListNode head){
        while (head !=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    @Test
    public void ReverseListNodeTest(){
        ListNode head = listNodeGenerate();
        listNodePrint(head);
        ReverseListNode rl = new ReverseListNode();
        ListNode l0 = rl.reverse1(head);
        ListNode l1 = rl.reverse2(head);
        ListNode l2 = rl.reverse3(head);
        System.out.println("----------------链表翻转--------------------");
        listNodePrint(l0);
        listNodePrint(l1);
        listNodePrint(l2);

    }

}
