package leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1631 {
    /**
     * 对于高度差绝对值的最大值范围是 1-10^6 ，进行二分查找：
     * 对于 mid ， 能够从 0,0  位置走到结束位置，则右边界更新为mid
     *            不能走到结束位置，则左边界更新为 mid
     *            最后结果返回 r
     * 每一次判断是否能够走到结束位置，利用 BFS
     */
    public int minimumEffortPath(int[][] heights) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int l = -1;
        int r = 1000000;
        int m = heights.length;
        int n = heights[0].length;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue= new LinkedList<>();
            queue.add(new int[] {0, 0});
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];
                    if (x <0 || x >= m || y <0 || y >= n) continue;
                    if (visited[x][y]) continue;
                    if (Math.abs(heights[x][y] - heights[cur[0]][cur[1]]) <= mid) {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                    }
                }
            }
            if (visited[m-1][n-1]) {
                r = mid;//走到结束位置后结束了 while 循环
            } else {
                l = mid;//没走到结束位置
            }
        }
        return r;
    }
}
