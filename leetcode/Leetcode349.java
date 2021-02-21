package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for (int i : nums1) {
            s.add(i);
        }
        for (int i : nums2) {
            if(s.contains(i)){
                l.add(i);
                s.remove(i);
            }
        }
        int[] result = new int[l.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = l.get(i);
        }
        return result;

    }
}
