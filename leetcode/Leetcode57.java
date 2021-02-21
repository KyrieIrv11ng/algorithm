package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] a = new int[intervals.length+1][2];
        for (int i = 0; i < intervals.length; i++) {
            a[i] = intervals[i];
        }
        a[a.length-1] = newInterval;
        intervals = a;
        if (intervals.length == 0) {
            return new int[0][2];
        }
        ArrayList<int[]> al = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {    //对区间左端点进行排序
                return o1[0]-o2[0];
            }
        });
        int start = intervals[0][0];    //取第一个区间左端点为起始端点
        int end = intervals[0][1];      //取第一个区间右端点端点为结束端点
        for (int i = 1;i < intervals.length;i++) {
            if(intervals[i][0] >= start && intervals[i][0] <= end && intervals[i][1]>=end){ //左端点在区间内，切右端点等于区间右端点或大于区间右端点，合并。
                end = intervals[i][1];  //合并就是把当前区间右端点更新为整个区间右端点  [1,2] + [2,3] -> [1,3]   [1,4] + [2,5] -> [1,5]
            }else if(intervals[i][0] > end){    //当前区间左端点大于区间右端点，
                al.add(new int[]{start,end});   //说明是断点，当区间加入到合并的区间,当前区间变为新区间 [1,3] [4,5]
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                continue; //如果不符合以上判断，则跳过  [1,4] + [1,3]   [1,4] + [2,3] 不做任何操作
            }
        }
        al.add(new int[]{start,end});       //追加最后一个区间
        return al.toArray(new int[al.size()][]);        //将list转换为array 注意里面 new int[al.size()][] 的操作
    }
}
