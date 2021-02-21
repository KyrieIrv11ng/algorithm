package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode155 {
    //我的方法
    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int x) {
            if(minStack.isEmpty()||x<=minStack.peek()){
                stack.push(x);
                minStack.push(x);
            }else{
                stack.push(x);
                int count = 0;
                while(!minStack.isEmpty()&&x>minStack.peek()){
                    count++;
                    stack.push(minStack.pop());
                }
                minStack.push(x);
                for (int i = 0; i < count; i++) {
                    minStack.push(stack.pop());
                }
            }
        }

        public void pop() {
            int temp = stack.pop();
            int count = 0;
            while(!minStack.isEmpty()&&minStack.peek()!=temp){
                count++;
                stack.push(minStack.pop());
            }
            minStack.pop();
            for (int i = 0; i < count; i++) {
                minStack.push(stack.pop());
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack1 {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public void MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack2 {

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int min;

        public MinStack2() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            dataStack.add(x);
            min = Math.min(min, x);
            minStack.add(min);
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
