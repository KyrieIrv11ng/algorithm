package leetcode.二叉树;

import leetcode.TreeNode;

import java.util.Arrays;

public class Leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历
        if(preorder.length==0){
            return null;
        }
        int rootVal = preorder[0];
        int rootIndex = 0;
        while(rootIndex<inorder.length){
            if(inorder[rootIndex]!=rootVal){
                rootIndex++;
            }else{
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+rootIndex),Arrays.copyOfRange(inorder,0,rootIndex));
        //左开右闭
        root.right = buildTree(Arrays.copyOfRange(preorder,rootIndex+1,preorder.length),Arrays.copyOfRange(inorder,rootIndex+1,inorder.length));
        return root;
        //返回结果
    }
}
