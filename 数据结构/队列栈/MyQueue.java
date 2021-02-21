package 数据结构.队列栈;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> push;
    private Stack<Integer> pop;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.push = new Stack<>();
        this.pop = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        push.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!pop.isEmpty()){
            return pop.pop();
        }else{
            while(!push.empty()){
                pop.push(push.pop());
            }
            return pop.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!pop.isEmpty()){
            return pop.peek();
        }else{
            while(!push.empty()){
                pop.push(push.pop());
            }
            return pop.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(push.empty()&&pop.empty()){
            return true;
        }else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
