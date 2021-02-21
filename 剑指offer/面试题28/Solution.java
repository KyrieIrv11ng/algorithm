package 剑指offer.面试题28;

import 数据结构.树.TreeNode;

public class Solution {
    //递归法
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return help(root.left,root.right);
    }
    public boolean help(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return help(left.left,right.right)&&help(right.left,left.right);
    }
}
