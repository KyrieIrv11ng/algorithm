package leetcode;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }
}
