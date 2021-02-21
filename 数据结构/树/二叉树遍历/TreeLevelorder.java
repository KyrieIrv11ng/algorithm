package 数据结构.树.二叉树遍历;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevelorder {
    public List<List<Integer>> levelOrder(leetcode.TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<leetcode.TreeNode> q = new LinkedList<>();
        leetcode.TreeNode cur = root;
        q.offer(cur);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> result1 = new ArrayList<>();
            while(count>0){
                TreeNode node = q.poll();
                result1.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                count--;
            }
            result.add(result1);

        }
        return result;

    }
}
