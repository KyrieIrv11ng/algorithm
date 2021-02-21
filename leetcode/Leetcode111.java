package leetcode;

public class Leetcode111 {
    //求最小深度时将Math.max换成Math.min即可，但要注意如果根节点
    // 的左或右子树为空的话是构不成子树的。而最小深度是要求从根节点到子树的。
    // 当左或右子树为空时，不符合要求。
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }


}
