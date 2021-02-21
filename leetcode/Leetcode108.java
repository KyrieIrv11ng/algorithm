package leetcode;

import java.util.Arrays;

public class Leetcode108 {
    //内存消耗大
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int mid = (nums.length-1)>>1;
        int rootVal = nums[mid];
        TreeNode root = new TreeNode(rootVal);
        root.left =  sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right =  sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        return root;
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        return bfs(nums,0,nums.length-1);
    }
    public TreeNode bfs(int[] nums,int left,int right){
        if(left>right) return null;
        int mid = left+((right-left)>>1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bfs(nums,left,mid-1);
        root.right = bfs(nums,mid+1,right);
        return root;
    }
}
