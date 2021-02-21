package 剑指offer.面试题55;

import 数据结构.树.TreeNode;

public class Solution {
    //递归
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
