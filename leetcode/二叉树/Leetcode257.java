package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        this.res = new ArrayList<>();
        if(root==null){
            return res;
        }
        dfs(root,"");
        return res;

    }
    public void dfs(TreeNode root,String s){
        if(root==null){
            return;
        }
        s = s+root.val;  //root不为空，加入当前的值
        if(root.left==null&&root.right==null){
            res.add(s);     //为叶子结点时，加入res
        }
        dfs(root.left,s+"->");//递归
        dfs(root.right,s+"->");
    }
}
