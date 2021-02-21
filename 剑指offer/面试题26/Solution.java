package 剑指offer.面试题26;

import 数据结构.树.TreeNode;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);//第一个是dfs判断，第二三个是遍历
    }

    public boolean dfs(TreeNode A ,TreeNode B){     //用dfs来判断是否是子结构
       if(B==null){
           return true;
       }
       if(A==null){
           return false;
       }
       return A.val==B.val && dfs(A.left,B.left)&&dfs(A.right,B.right);
    }
}
