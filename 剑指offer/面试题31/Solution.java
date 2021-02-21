package 剑指offer.面试题31;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pop = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            s.push(pushed[i]);
            while(!s.isEmpty()&&s.peek()==popped[pop]){
                s.pop();
                pop++;
            }
        }
        return s.isEmpty();
    }
}
