package leetcode.队列和栈;

import java.util.Stack;

public class Leetcode84 {
    //暴力法，找每一个高度左右两边大于其高度，然后就每一个高度最多能占左右多少个面积
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while(left>0&&heights[left-1]>=heights[i]){
                left--;
            }
            while(right<heights.length-1&&heights[right+1]>=heights[i]){
                right++;
            }
            res = Math.max(res,(right-left+1)*heights[i]);
        }
        return res;
    }
    //单调栈
    public static int largestRectangleArea1(int[] heights){
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        //左右各加一个哨兵元素
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tmp.length; i++) {
            while(!s.isEmpty()&&tmp[i]<tmp[s.peek()]){      //栈为空且当前元素小于栈顶元素，就弹出
                int h = tmp[s.pop()];
                res = Math.max(res,(i-s.peek()-1)*h);       //并计算当前的面积
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,4,1,2};
        System.out.println(largestRectangleArea1(a));
    }
}
