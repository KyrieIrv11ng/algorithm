package leetcode;

import java.util.ArrayList;

public class Leetcode501 {
    int preVal = 0;
    int max = Integer.MIN_VALUE;
    int count = 0;
    ArrayList<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        inorder(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(root.val==preVal){
            count++;
        }else{
            preVal = root.val;
            count = 1;
        }
        if(count>max){
            max = count;
            res.clear();
            res.add(root.val);
        }else if(count==max){
            max = count;
            res.add(root.val);
        }
        inorder(root.right);
    }
}
