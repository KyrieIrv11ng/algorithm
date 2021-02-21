package leetcode;

public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        if(!isSameTree(p.left,q.left)||!isSameTree(p.right,q.right)){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return true;
    }
}
