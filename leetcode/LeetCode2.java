package leetcode;

/**
 * 两数相加，链表题
 */

public class LeetCode2 {
    /*
    我的代码
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);    //定义头结点
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = (l1 == null ? 0 : l1.val);
            int num2 = (l2 == null ? 0 : l2.val);
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int value = sum % 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head.next;

    }
    /*
    官方代码
     */

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }


}
