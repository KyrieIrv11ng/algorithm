package leetcode;

public class Leetcode45 {
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {// -1是因为到达最后一个，倒数第二个就可以到达了，就不用到达最后一个了，就是最后一个就不用跳了
            max = Math.max(max,i+nums[i]);
            if(i==end){
                end = max;
                ans++;
            }
        }
        return ans;
    }
}
