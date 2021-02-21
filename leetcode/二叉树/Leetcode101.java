package leetcode.二叉树;

import leetcode.TreeNode;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return help(root.left,root.right);
        }
    }
    public boolean help(TreeNode left,TreeNode right){
        if(left==null && right ==null){
            return  true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return help(left.right,right.left)&&help(right.right,left.left);
    }
}
