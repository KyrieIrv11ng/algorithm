package leetcode.队列和栈.单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双端单调队列
        int[] res = new int[nums.length-k+1];
        Deque<Integer> de = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if(!de.isEmpty()&&((i-de.peekFirst())>=k)){
                de.pollFirst();
            }   //维护队列窗口大小
            //维护单调队列
            while(!de.isEmpty()&&nums[i]>nums[de.peekLast()]){
                de.pollLast();
            }
            de.addLast(i);
            //找出每个窗口的最大值
            if(i>=k-1){
                res[i-k+1]=nums[de.peekFirst()];
            }
        }
        return res;
    }
}
