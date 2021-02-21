package leetcode;

public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)||!isValidBST(root.right)){//左右只要一个不是搜索树，返回false
            return false;
        }
        if(root.left!=null&&root.left.val>=root.val){//左边大于等于右边，返回false
            return false;
        }
        if(root.right!=null&&root.right.val<=root.val){//右边大于等于左边，返回false
            return false;
        }
        if(root.left!=null&&righthelper(root.left).val>=root.val){//左子树的最右叶节点大于等于根，返回false
            return false;
        }
        if(root.right!=null&&lefthelper(root.right).val<=root.val){//右子树的最左叶节点大于等于根，返回false
            return false;
        }
        return true;
    }
    public TreeNode lefthelper(TreeNode root){//遍历
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public TreeNode righthelper(TreeNode root){//遍历
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
}
