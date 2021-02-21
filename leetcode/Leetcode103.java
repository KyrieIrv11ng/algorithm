package leetcode;

import java.util.*;

public class Leetcode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<List<Integer>>();
        }
        boolean flag = true;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                if(tmp.left!=null){
                    q.offer(tmp.left);
                }
                if(tmp.right!=null){
                    q.offer(tmp.right);
                }
                if(flag){
                    list.add(tmp.val);
                }else{
                    s.add(tmp.val);
                }
            }
            while(!s.isEmpty()){
                list.add(s.pop());
            }
            res.add(new ArrayList<>(list));
            flag = !flag;
        }
        return res;
    }
}
