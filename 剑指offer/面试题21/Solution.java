package 剑指offer.面试题21;

import java.util.Arrays;
import java.util.Comparator;
//方法1 快排
public class Solution {
    public int[] exchange(int[] nums) {
        int less = -1;
        int more = nums.length;
        int left = 0;
        while(left<more){
            if(nums[left]%2==1){
                swap(nums,++less,left++);
            }else{
                swap(nums,--more,left);
            }
        }
        return nums;
    }
    public void swap(int[]nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //方法2Compartor
    public int[] exchange1(int[] nums) {
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = nums[i];
        }

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1%2==1&&o2%2==1){
                    return o1-o2;
                }
                if(o1%2==1){
                    return -1;
                }
                if(o2%2==1){
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = array[i].intValue();
        }
        return nums;
    }
}
