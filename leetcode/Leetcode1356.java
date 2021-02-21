package leetcode;

import java.util.*;

public class Leetcode1356 {
    public int[] sortByBits(int[] arr) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i]=arr[i];
        }

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int c1 = getoneNumber(o1);
                int c2 = getoneNumber(o2);
                if(c1==c2){
                    return o1-o2;
                }else return c1-c2;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }
    public int getoneNumber(int temp){
        int res = 0;
        while(temp!=0){
            if(temp%2==1){
                res++;
            }
            temp = temp/2;
        }
        return res;
    }
}
