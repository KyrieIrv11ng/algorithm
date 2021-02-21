package 剑指offer.面试题32_3;

import 数据结构.树.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        boolean flag = true;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
                if (flag){
                    list.add(tmp.val);
                }else{
                    s.push(tmp.val);
                }
            }
            flag = !flag;
            while(!s.isEmpty()){
                list.add(s.pop());
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
