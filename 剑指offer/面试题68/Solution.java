package 剑指offer.面试题68;

import 数据结构.树.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);//pq有没有都在左边
        TreeNode right = lowestCommonAncestor(root.right,p,q);//qp有没有都在右边
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
}
