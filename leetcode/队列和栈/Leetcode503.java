package leetcode.队列和栈;

import 数据结构.数组.Array;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next,-1);
        Stack<Integer> min = new Stack<>();
        for (int i = 0; i < n*2; i++) {
            int num = nums[i%n];
            while(!min.isEmpty()&&num>nums[min.peek()]){
                int temp = min.pop();
                next[temp] = num;
            }
            if(i<n){
                min.push(i);//只存储数组中的值
            }
        }
        return next;
    }
}
