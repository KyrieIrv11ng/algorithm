package 剑指offer.面试题35;

import 剑指offer.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //方法1 用Map映射
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node,Node> m = new HashMap<>();
        while(cur!=null){
            m.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        Node cur2 = head;
        while(cur2!=null){
            m.get(cur2).next = m.get(cur2.next);
            m.get(cur2).random = m.get(cur2.random);
            cur2 = cur2.next;
        }
    return m.get(head);
    }

    //方法2
    public Node copyRandomList2(Node head) {
        //先将复制结点连接到每一个结点后面，调整random指针，再分离两个链表
        if(head==null){
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node res = head.next;
        while (cur.next.next != null) {
            Node temp = cur.next.next;
            cur.next.next = temp.next;
            cur.next = temp;
            cur = temp;
        }
        cur.next.next = null;
        cur.next = null;
        return res;
    }
}
