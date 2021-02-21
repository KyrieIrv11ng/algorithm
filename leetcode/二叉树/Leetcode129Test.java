package leetcode.二叉树;

import leetcode.TreeNode;
import org.junit.Test;

public class Leetcode129Test {
    @Test
    public void Test(){
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(9);
        node.right = new TreeNode(0);
        node.left.left =  new TreeNode(5);
        node.left.right =  new TreeNode(1);

        Leetcode129 l = new Leetcode129();
        int i = l.sumNumbers(node);
        System.out.println(i);
    }



}
