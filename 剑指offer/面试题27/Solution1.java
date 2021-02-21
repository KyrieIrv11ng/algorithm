package 剑指offer.面试题27;

import 数据结构.树.TreeNode;

import java.util.Stack;

public class Solution1 {
    //迭代，中序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode pop = s.pop();
            if(pop.right!=null){
                s.push(pop.right);
            }
            if(pop.left!=null){
                s.push(pop.left);
            }
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
        }
        return root;
    }
}
