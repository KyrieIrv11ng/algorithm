package leetcode.递归.分治;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new ArrayList<TreeNode>();
        }
        return generateSubtrees(1,n);
    }

    private List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start>end){//终止条件，当起始大于终止的时候
            res.add(null);
            return res;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> left = generateSubtrees(start, i-1);
            List<TreeNode> right = generateSubtrees(i+1, end);
            for (TreeNode node : left) {
                for (TreeNode treeNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node;
                    root.right = treeNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
