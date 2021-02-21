package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //我的方法，先用map存arr1里面的数以及出现次数，再根据arr2里面的数的顺序，
        // 将arr1中的数填到res中，最后再将不存在的数填进去，对后面的数排序
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            m.put(arr1[i],m.getOrDefault(arr1[i], 0) + 1);
        }
        int[] res = new int[arr1.length];
        int j = 0;
        int i = 0;
        for (; i < res.length; i++) {
            if(m.get(arr2[j])==0) {
                j++;
            }
            if(j==arr2.length){
                break;
            }
            res[i] = arr2[j];
            int temp = m.get(arr2[j]) - 1;
            m.put(arr2[j],temp);
        }
        for (int k = 0; k < arr1.length; k++) {
            if(m.get(arr1[k])!=0){
                res[i] = arr1[k];
                i++;
            }
        }
        Arrays.sort(res,i,arr1.length);
        return res;
    }

    //方法2利用compartor
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        // Comparator must be generic, so we have to do this
        Integer[] array = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            array[i] = arr1[i];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (map.containsKey(a) && map.containsKey(b)) {
                    return map.get(a) - map.get(b);
                }
                // a < b
                if (map.containsKey(a)) {
                    return -1;
                }
                // b < a
                if (map.containsKey(b)) {
                    return 1;
                }
                return a - b;
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = array[i].intValue();
        }
        return arr1;
    }

}
