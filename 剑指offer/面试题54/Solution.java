package 剑指offer.面试题54;

import 数据结构.树.TreeNode;

import java.util.Stack;

public class Solution {
    //中序遍历迭代， 右根左
    public int kthLargest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        int res = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(!s.isEmpty()||cur.right!=null){
            while(cur!=null){
                s.push(cur);
                cur = cur.right;
            }
            TreeNode temp = s.pop();
            res++;
            if(res == k){
                return temp.val;
            }
            if(temp.left!=null){
                cur = temp.left;
            }
        }
        return -1;
    }
}
