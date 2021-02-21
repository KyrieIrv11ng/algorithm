package leetcode;

public class Leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            res = root.left.val;        //累积左叶子节点和
        }
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        return left+right+res;
    }
}
