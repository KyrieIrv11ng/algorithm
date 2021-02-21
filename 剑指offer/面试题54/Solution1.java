package 剑指offer.面试题54;

import 数据结构.树.TreeNode;

public class Solution1 {

    //递归
    private int ans = 0;
    private int count = 0;
    public int kthLargest(TreeNode root, int k) {
        help(root,k);
        return ans;
    }

    public void help(TreeNode root, int k){
        if(root==null){
            return;
        }
        help(root.right,k);
        count++;
        if(count == k){
            ans = root.val;
            return;
        }

        help(root.left,k);
    }
}
