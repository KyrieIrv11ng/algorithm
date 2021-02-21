package leetcode.队列和栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode496 {
    //维护一个单调减的栈，遇到大于的出栈，并保存到map中，即依次都为某个数右边最大的第一个数字
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while(!s.isEmpty()&&nums2[i]>s.peek()){
                int tmp = s.pop();
                m.put(tmp,nums2[i]);
            }
            s.push(nums2[i]);
        }
        while(!s.isEmpty()){
            m.put(s.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = m.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2};
        int[] b = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(a,b)));
    }
}
