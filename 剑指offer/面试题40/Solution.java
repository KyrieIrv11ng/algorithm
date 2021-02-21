package 剑指offer.面试题40;

import 数据结构.数组.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if(k==0){
            return result;
        }
        PriorityQueue<Integer> res = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < k; i++) {
            res.offer(arr[i]);
        }
        for(int i = k;i<arr.length;i++){
            if(res.peek()>arr[i]){
                res.poll();
                res.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = res.poll();
        }
        return result;
    }


}
