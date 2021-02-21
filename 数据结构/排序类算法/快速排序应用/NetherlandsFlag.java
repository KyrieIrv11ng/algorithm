package 数据结构.排序类算法.快速排序应用;

public class NetherlandsFlag {
    public static int[] partition(int[]nums ,int left,int right,int target){
        int less = left-1;  //  定义小于区域
        int more = right+1;
        //定义大于区域
        int cur = left;
        while(cur<more){
            if(nums[cur]<target){      //如果当前的数小于目标数，就与小于区的后一个数交换，并且坐标同时++
                swap(nums,++less,cur++);
            }else if(nums[cur]>target){//如果当前的数大于目标数，就与大于区的前一个数交换，大于区扩大，当前数坐标不变，继续判断当前的数
                swap(nums,--more,cur);
            }else{
                cur++;      //相等的话cur++
            }
        }
        return new int[]{less+1,more-1};
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
