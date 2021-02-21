package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode241 {
    Map<String,List<Integer>> m = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(m.containsKey(input)){
            return m.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (!Character.isDigit(tmp)) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (Integer value : left) {
                    for (Integer item : right) {
                        if (tmp == '+') {
                            res.add(value + item);
                        } else if (tmp == '-') {
                            res.add(value - item);
                        } else if (tmp == '*') {
                            res.add(value * item);
                        }
                    }
                }
            }
        }
        if(res.size()==0){//只有一个数的情况
            res.add(Integer.parseInt(input));
        }
        m.put(input,res);
        return res;
    }
}


