package 剑指offer.面试题39;

public class Solution3 {
    public int majorityElement(int[] nums) {
        //不同的进行抵消
        int num = 0;
        int volate = 0;
        for (int i = 0; i < nums.length; i++) {
            if(volate==0){
                num = nums[i];
            }
            if(nums[i]==num){
                volate ++;
            }else{
                volate--;
            }
        }
        return num;
    }
}
