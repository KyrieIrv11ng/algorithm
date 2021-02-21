package leetcode;

public class Leetcode509 {
    public int fib(int N) {
        int[] nums = {0,1};
        if(N==0||N==1){
            return nums[N];
        }
        int pre = nums[0];
        int cur = nums[1];
        int ans = 0;
        for(int i = 2;i<=N;i++){
            ans = pre + cur;
            pre = cur;
            cur = ans;
        }
        return ans;
    }
}
