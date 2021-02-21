package leetcode;

public class Leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= s)
                return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end]; //统计数的和
            while (sum >= s) {//如果和大于s，左侧start值就一直向右移动直到小于s时，end向右移动
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public int minSubArrayLen2(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while(end<nums.length){
            if(sum<s){
                sum = sum + nums[end];
                end++;
            }
            while(sum>=s){
                ans = Math.min(ans,end-start);
                sum = sum-nums[start];
                start++;
            }
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }

    public int minSubArrayLen3(int s, int[] nums) {
        int start = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while(sum>=s){
                ans = Math.min(ans,i-start+1);
                sum = sum - nums[start];
                start++;
            }
        }
        return ans == Integer.MAX_VALUE?0:ans;
    }
}
