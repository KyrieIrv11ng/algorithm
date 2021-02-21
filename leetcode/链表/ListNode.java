package leetcode.链表;

public class ListNode {
    public ListNode next;
    public int val;
      ListNode() {

      }
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
}
