package leetcode.贪心;

public class Leetcode55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        //贪心算法
        for (int i = 0; i < nums.length; i++) {
            if(max<i){      //如果跳跃最大的跳不到当前的位置，即表示跳不过去，所以返回false
                return false;
            }else{
                max = Math.max(max,i+nums[i]);  //能跳的话计算当前位置能跳到哪个位置
            }
        }
        return true;
    }
}
