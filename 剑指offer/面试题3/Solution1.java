package 剑指offer.面试题3;
/*
    时间复杂度O(n),空间复杂度O(1),前提是要改变原数组
    基本思想：
    在数组中进行交换
    在n大小的数组中,如果不重复，排序后的话,其下标应该等于其索引
    {0,1,2,3,4,5,6}
 */
public class Solution1 {
    public int findRepeatNumber(int[] nums) {
        if(nums.length==0||nums.length==1){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0||nums[i]>nums.length-1){
                return -1;
            }
        }

        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){  //直到找到nums[i]==nums[nums[i]时，即存在重复{0,1,2,3,4,-> 2 <-重复 ，5,6}
                    return nums[i];
                }
                swap(nums,i,nums[i]);  //如果nums[i]不等于其下标i,则nums[i]与i上的数交换,一直交换，直到nums[i]等于其下标索引i为止
            }
        }
        return -1;
    }

    public static void swap(int[] nums,int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
