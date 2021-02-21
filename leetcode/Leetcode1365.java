package leetcode;

public class Leetcode1365 {
    //方法1.我的方法，暴力法
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] largerNums = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    largerNums[j]++;
                }
                if(nums[i]>nums[j]){
                    largerNums[i]++;
                }

            }
        }
        return largerNums;
    }
    //方法2.
    // 计数排序 有值域，所以开辟数组，大小为100，nums中的数的个数，存放
    // 在新开的数组中，然后遍历数组，每次位置上的数等于之前所有位置上的和，即最后求出来每个位置上的数
    // 即为比他小的数的个数
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }

    //方法3.
    //1.快速排序
    //2.开辟数组
    //3.返回左侧数的下标+1


}
