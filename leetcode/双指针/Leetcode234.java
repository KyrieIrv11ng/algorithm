package leetcode.双指针;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Leetcode234 {
    /*
    方法一（我的方法）：
    利用stack 把所有数压入栈中，再从头遍历
     */
    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        if (cur == null || cur.next == null){
            return true;
        }
        while(cur!=null){
            s.push(cur.val);
            cur = cur.next;
        }
        while(head!=null){
            if(s.pop()!=head.val){
                return false;
            }else{
                head = head.next;
            }
        }

        return true;
    }
    /*
    方法二：利用linklist，复制到数组中，利用双指针
     */
    public boolean isPalindrome2(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }


}
