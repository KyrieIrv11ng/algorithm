package 剑指offer.面试题7;

import 数据结构.树.TreeNode;

import java.util.Arrays;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int rootVal = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(rootVal==inorder[i]){
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+rootIndex),Arrays.copyOfRange(inorder,0,rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder,rootIndex+1,preorder.length),Arrays.copyOfRange(inorder,1+rootIndex,inorder.length));
        return root;
    }
}
