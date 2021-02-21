package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode129 {
    int ans;
    //层序遍历
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        TreeNode cur = root;
        q.offer(cur);
        q1.offer(cur.val);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int num = q1.poll();
            if(node.left == null&&node.right==null){
                sum = sum + num;
            }
            if (node.left != null) {
                q.offer(node.left);
                q1.offer(num*10+node.left.val);
            }
            if (node.right != null) {
                q.offer(node.right);
                q1.offer(num*10+node.right.val);
            }

        }
        return sum;
    }
    //递归遍历
    public int sumNumbers1(TreeNode root) {
        ans = 0;
        if(root==null){
            return 0;
        }
        dfs(root,0);
        return ans;

    }
    public void dfs(TreeNode root,int res){
        if(root==null){
            return;
        }
        res = res*10 + root.val;
        if(root.left==null&&root.right==null){
            ans = ans+res;
            return;
        }
        dfs(root.left,res);
        dfs(root.right,res);
    }
}
