package 剑指offer.面试题6;

import leetcode.ListNode;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        int sum = 0;
        while(cur!=null){
            sum++;
            cur = cur.next;
        }
        int[] nums = new int[sum];
        for(int i = nums.length-1;i>=0;i--){
            nums[i] = head.val;
            head = head.next;
        }
        return nums;
    }


}
