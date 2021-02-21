package leetcode.用java_Comparable接口进行排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    //题解方法，直接用Arraylist插入
    public int[][] reconstructQueue1(int[][] people) {
        if (0 == people.length || 0 == people[0].length)
            return new int[0][0];
        //按照身高降序 K升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        //K值定义为 排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此K值即为需要插入的位置
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);

    }
}
