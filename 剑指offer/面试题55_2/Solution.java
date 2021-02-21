package 剑指offer.面试题55_2;

import 数据结构.树.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        if(Math.abs(getHigh(root.left)-getHigh(root.right))>1){
            return false;
        }
        return true;
    }
    public int getHigh(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHigh(root.right),getHigh(root.left))+1;
    }
}
