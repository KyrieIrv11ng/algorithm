package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    List<Integer> list;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.list = new ArrayList<>();
        this.result = new ArrayList<>();
        dfs(root,sum);
        return result;
    }
    public void dfs(TreeNode root, int sum){
        if(root==null){         //如果为空，直接返回
            return;
        }
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                result.add(new ArrayList<>(list)); //如果为叶子结点，并且值等于sum，将list加入result

            }
            list.remove(list.size()-1);     //每次到叶子结点，都要remove掉最后一个元素，回溯
            return;             //return回去
        }
        dfs(root.left,sum-root.val);        //递归
        dfs(root.right,sum-root.val);       //递归
        list.remove(list.size()-1);     //回溯
    }
}
