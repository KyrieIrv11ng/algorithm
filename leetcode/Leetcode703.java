package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Leetcode703 {
    class KthLargest {
        private int k;
        private PriorityQueue<Integer> pq ;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.pq  = new PriorityQueue<Integer>();
            for (int i = 0; i < nums.length; i++) {
                pq.offer(nums[i]);
            }
        }

        public int add(int val) {
            pq.offer(val);
           while(pq.size()>k){
               pq.poll();
           }
           return pq.peek();
        }
    }
}
