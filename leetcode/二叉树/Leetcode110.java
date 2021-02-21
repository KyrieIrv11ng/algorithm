package leetcode.二叉树;

import leetcode.TreeNode;

public class Leetcode110 {
    //我的方法，自顶向下
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(height(root.left)-height(root.right))<=1;

    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    //自底向上
    public boolean isBalanced1(TreeNode root) {
        return height1(root) >= 0;
    }

    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;      //减枝
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


}
