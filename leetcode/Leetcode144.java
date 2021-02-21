package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {

    //1.递归方法
    public List<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> al = new ArrayList<>();
       preorder(root,al);
       return al;
    }

    public static void preorder(TreeNode root,ArrayList<Integer> al){
        if(root==null){
            return;
        }
        al.add(root.val);
        preorder(root.left,al);
        preorder(root.right,al);
    }
    //2.迭代方法
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrderIteration(root,result);
        return result;
    }
    public static void preOrderIteration(TreeNode root,ArrayList<Integer> result){
        if(root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        s.push(cur);//先入父节点
        while(!s.empty()){
            TreeNode node = s.pop();//将父节点弹出，并用node保存   每次弹出的节点，都将作为父节点来使用
            result.add(node.val);//打印父节点数值
            if(node.right!=null){   //父节点右孩子入栈
                s.push(node.right);
            }
            if(node.left!=null){        //父节点左孩子入栈
                s.push(node.left);
            }                       //下一个循环拿出其左孩子，没有做孩子就拿右孩子当父节点，继续操作，
                                    // 即完成了前序遍历的操作  根左右
        }
    }
}
