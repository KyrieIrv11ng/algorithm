package 数据结构.队列栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size()>1){
            q2.add(q1.poll());
        }
        int temp = q1.poll();
        swap();
        return temp;
    }

    /** Get the top element. */
    public int top() {
        while (q1.size()>1){
            q2.add(q1.poll());
        }
        int temp = q1.peek();
        q2.add(q1.poll());
        swap();
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q1.size()==0){
            return true;
        }else return false;
    }

    public void swap(){
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}