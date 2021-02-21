package leetcode.二叉树;

import leetcode.TreeNode;

public class Leetcode222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
}
