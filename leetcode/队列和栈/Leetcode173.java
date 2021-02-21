package leetcode.队列和栈;

import leetcode.TreeNode;

import java.util.Stack;

public class Leetcode173 {
    //字节题库
    class BSTIterator {
        private Stack<TreeNode> s ;
        private TreeNode cur;
        public BSTIterator(TreeNode root) {
            cur = root;
            this.s = new Stack<>();
        }

        public int next() {
            if(hasNext()){
                TreeNode tmp = s.pop();
                if(tmp.right!=null){
                    cur = tmp.right;
                }
                return tmp.val;
            }
            return -1;
        }

        public boolean hasNext() {
           while(cur!=null){
               s.push(cur);
               cur = cur.left;
           }
           return !s.isEmpty();
        }
    }
}
