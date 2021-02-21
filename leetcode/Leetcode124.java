package leetcode;

public class Leetcode124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));       //左边如果是负数就是最大是0
        int right = Math.max(0,dfs(root.right));
        ans = Math.max(ans,left+right+root.val);        //答案为左边路径和加右边路径和加自身的val
        return Math.max(left,right)+root.val;   //每次只有一条路径去走 子-》父-》子
    }
}
