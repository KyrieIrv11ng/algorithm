package 剑指offer.面试题57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            int ans = 0;
            for(int j = i;j< target;j++){
                ans = ans + j;
                if(ans == target){
                    int[] list = new int[j-i+1];
                    int temp = i;
                    for (int k = 0; k < list.length; k++) {
                        list[k] = temp;
                        temp = temp+1;
                    }
                    res.add(list);
                }
                if(ans > target){
                    break;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(15));
    }
}
