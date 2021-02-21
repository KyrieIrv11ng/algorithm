package 剑指offer.面试题59_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];
        Deque<Integer> de = new ArrayDeque<>();//创建双端队列
        for (int i = 0; i < nums.length; i++) {
            if((!de.isEmpty()&&(i-de.getFirst())>=k)){//如果当前长度减去当前区间最大的值的长度大于给定区间K的长度
                                                // ，就把当前最大值出队，保留下一个最大的数（在区间内）
                de.pollFirst();                 //出队
            }
            while(!de.isEmpty()&&nums[i]>nums[de.getLast()]){
                de.pollLast();                  //维护单调增队列
            }
            de.addLast(i);                      //入队
            if(i>=k-1){                         //从此时开始计算区间内最大值
                res[i-k+1] = nums[de.getFirst()];
            }
        }
        return res;
    }
}
