package 剑指offer.面试题55;

import 数据结构.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//层序遍历
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int high = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            high++;
        }
        return high;
    }
}
