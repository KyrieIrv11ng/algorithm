package leetcode;

public class Leetcode138 {
    public Node copyRandomList(Node head) {
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
