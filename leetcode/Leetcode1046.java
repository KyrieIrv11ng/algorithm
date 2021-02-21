package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int res = Math.abs(pq.poll()-pq.poll());
            if(res!=0){
                pq.add(res);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }else{
            return pq.poll();
        }
    }
}
