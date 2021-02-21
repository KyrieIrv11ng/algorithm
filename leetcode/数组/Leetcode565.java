package leetcode.数组;

public class Leetcode565 {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int num = i;
            while(nums[num]!=-1){
                int tmp = num;
                num = nums[num];
                nums[tmp] = -1;
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
