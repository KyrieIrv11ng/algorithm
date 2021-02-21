package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode145 {
    //1.递归方法
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        postorder(root,al);
        return al;
    }

    public static void postorder(TreeNode root,ArrayList<Integer> al){
        if(root==null){
            return;
        }

        postorder(root.left,al);
        postorder(root.right,al);
        al.add(root.val);
    }

    //2.迭代方法1
    //用前序遍历的方法
    //前序：根左右
    //后序：左右根
    //根右左，通过栈，编程左右根
    //即在前序遍历的基础上，先入左节点后入右节点

    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        postorderIteration(root,al);
        return al;
    }
    public static void postorderIteration(TreeNode root, ArrayList<Integer> res){
        if(root==null){
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode cur = root;
        s1.push(root);
        while(!s1.empty()){
            TreeNode node = s1.pop();
            s2.push(node);           //储存节点
            if(node.left!=null){
                s1.push(node.left);
            }
            if(node.right!=null){
                s1.push(node.right);
            }
        }
        while(!s2.empty()){
            res.add(s2.pop().val);
        }
    }

    //迭代方法2：
    //没懂
    public static void postOrderIteration(TreeNode head,ArrayList<Integer> res) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }
    }


}
