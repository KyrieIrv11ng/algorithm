package leetcode;

public class Leetcode1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head!=null){
            ans = ans*2+head.val;
            head = head.next;
        }
        return ans;
    }
}
