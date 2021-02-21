package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {
    //1.递归方法
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root,al);
        return al;
    }

    public static void inorder(TreeNode root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
    }
    //2.迭代方法
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inorderIteration(root,al);
        return al;
    }
    public static void inorderIteration(TreeNode root,ArrayList<Integer> res){
        if(root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root; //标记当前节点
        while(!s.empty() || cur!=null){     //左子树为空的话会出现栈空的情况
            while(cur!=null){           //一直入左子树节点
                s.push(cur);            //节点入栈
                cur = cur.left;
            }
            TreeNode node = s.pop();        //为空时弹出节点，用node保存
            res.add(node.val);              //储存当前node值
            if(node.right!=null){           //如果有右节点,当前节点指向树的右节点，右节点成为新的根节点
                cur = cur.right;            //继续重复看看当前节点有无左子树节点，有就一直入
            }
        }
    }

}
