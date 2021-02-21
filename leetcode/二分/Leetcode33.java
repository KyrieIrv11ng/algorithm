package leetcode.二分;

public class Leetcode33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {//看mid是在左半段还是右半段
                if (target >= nums[left] && target < nums[mid]) {//如果在左半段的话，且target的值在左边排好序的里面，就二分为左半段
                    right = mid - 1;
                } else {
                    left = mid + 1;//反之
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {//如果在右半段的话，且target的值在右边排好序的里面，就二分为右半段
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
