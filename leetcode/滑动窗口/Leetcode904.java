package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class Leetcode904 {
    public int totalFruit(int[] tree) {
        int n = tree.length;
        int left = 0;
        int ans = 0;
        if(n==0){
            return 0;
        }
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(tree[i],m.getOrDefault(tree[i],0)+1);
            while(m.size()>2){
                m.put(tree[left],m.get(tree[left])-1);
                if(m.get(tree[left])==0){
                    m.remove(tree[left]);
                }
                left++;
            }
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }
}
