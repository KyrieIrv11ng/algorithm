package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c1 = getpingfang(o1);
                int c2 = getpingfang(o2);
                return c1-c2;
            }
        });
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }

    public int getpingfang(int[] o1){
        return o1[0]*o1[0] + o1[1]*o1[1];
    }
}
