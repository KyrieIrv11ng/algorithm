package leetcode;
import 数据结构.数组.Array;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode71 {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        System.out.println(Arrays.toString(s));
        for (String value : s) {
            if (value.isEmpty() || value.equals(".")) {
                continue;
            }
            if (value.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                stack.push(value);
            }
        }
        return "/"+String.join("/",stack);
    }
}
