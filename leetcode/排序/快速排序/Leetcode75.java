package leetcode.排序.快速排序;

public class Leetcode75 {
    //快速排序，荷兰国旗问题
    public void sortColors(int[] nums) {
        int less = -1;
        int more = nums.length;
        int cur = 0;
        while(cur<more){
            if(nums[cur]==0){
                swap(nums,++less,cur++);
            }else if(nums[cur]==2){
                swap(nums,--more,cur);
            }else if(nums[cur]==1){
                cur++;
            }
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
