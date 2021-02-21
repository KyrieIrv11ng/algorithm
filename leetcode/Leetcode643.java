package leetcode;

public class Leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        int ans = 0;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            ans = ans + nums[i];
        }
        max = Math.max(max,ans);
        for(int i = k;i<nums.length;i++){
            ans = ans + nums[i];
            ans = ans - nums[i-k];
            max = Math.max(max,ans);
        }
        return max/k;
    }
}
