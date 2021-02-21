package 剑指offer.面试题34;

import 数据结构.数组.Array;
import 数据结构.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        dfs(root,sum);
        return res;
    }
    public void dfs(TreeNode root,int sum){
        if(root==null||sum<0){
            return;
        }
        list.add(root.val);
        sum = sum-root.val;
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(list));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        list.remove(list.size()-1);
    }
}
