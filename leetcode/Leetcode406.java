package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode406 {
    //我的方法
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }else return o2[0] - o1[0];
            }
        });
        int num = people.length;
        for (int i = 0; i < num; i++) {
            int index = people[i][1];
            for(int j = i-1;j>=index;j--){
                int[] temp = people[j+1];
                people[j+1] = people[j];
                people[j] = temp;
            }
        }
        return people;
    }
}
