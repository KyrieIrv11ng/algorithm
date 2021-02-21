package leetcode.用java_Comparable接口进行排序;

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

    //官方解
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

}
