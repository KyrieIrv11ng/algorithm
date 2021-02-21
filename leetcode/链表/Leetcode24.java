package leetcode.链表;

import leetcode.ListNode;

public class Leetcode24 {
    //递归方法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {        //递归终止条件
            return head;
        }
        //宏观上看是三个结点进行交换
        ListNode next = head.next;      //找到中间结点
        head.next = swapPairs(next.next);       //将第一个结点的next指针指向第三个结点
        next.next = head;               //将第二个结点的指针的next指向第一个结点
        return next;
    }
    //迭代方法
    //创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
    //
    //如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
    //
    //具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
    //
    //
    //temp.next = node2
    //node1.next = node2.next
    //node2.next = node1
    //完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
    //
    //两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可。

    public ListNode swapPairs1(ListNode head) {
        ListNode dummyHead = new ListNode(0);   //创建临时结点
        dummyHead.next = head;      //连接
        ListNode temp = dummyHead;      //定义临时结点
        //每次交换临时结点的后面两个结点
        while(temp.next!=null&&temp.next.next!=null){//temp后面只有一个结点的话或者没有结点就不换
            ListNode node1 = temp.next;     //第一个结点在临时结点后面
            ListNode node2 = temp.next.next;    //第二个结点在临时结点的后面的后面
            //具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，
            // 因此需要进行如下操作。
            //temp.next = node2
            //node1.next = node2.next
            //node2.next = node1
            //完成上述操作之后，节点关系即变成 temp -> node2 -> node1。
            // 再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
            //
            temp.next = node2;      //交换结点
            node1.next = node2.next;        //交换结点
            node2.next = node1;         //交换结点
            temp = node1;       //temp指向交换结点后的node1，等于跳了两个结点
        }
        return dummyHead.next;
    }
}
