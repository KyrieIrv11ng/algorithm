package leetcode.队列和栈.单调栈;

import java.util.Stack;

public class Leetcode42 {
    //暴力法，找每个高度左右最高的高度，然后求左右高度中最低的，求出最低高度和当前高度的差
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length-1; i++) {
            int leftHigh = 0;
            int rightHigh = 0;
            for(int j = 0;j<=i;j++){
                leftHigh = Math.max(leftHigh,height[j]);
            }

            for(int j = i;j<height.length;j++){
                rightHigh = Math.max(rightHigh,height[j]);
            }
            res = res + Math.min(leftHigh,rightHigh) - height[i];
        }
        return res;
    }
    //单调栈
    public int trap1(int[] height) {
        if(height.length==0){
            return 0;
        }
        int n = height.length;
        int[][] dp = new int[height.length][2];
        dp[0][0] = height[0];
        dp[n-1][1] = height[n-1];
        //记录每个节点左侧最大值
        for (int i = 1; i < height.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],height[i]);
        }
        //记录每个节点右侧最大值
        for (int i = n-2; i > 0; i--) {
            dp[i][1] = Math.max(dp[i+1][1],height[i]);
        }
        int res = 0;
        for (int i = 1; i < n-1; i++) {
            res = res + Math.min(dp[i][0],dp[i][1])-height[i];
        }
        return res;
    }
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // 遍历每个柱体
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int bottomIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[bottomIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    // stack.peek()是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
                    // Math.min(height[stack.peek()], height[i]) 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
                    // i - stack.peek() - 1 是雨水的宽度。
                    res += (Math.min(height[stack.peek()], height[i]) - height[bottomIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
