package leetcode;

public class Leetcode1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 1; i < coordinates.length-1; i++) {
            int y1 = coordinates[i][1] -coordinates[i-1][1];
            int x1 = coordinates[i][0] -coordinates[i-1][0];
            int y2 = coordinates[i+1][1] -coordinates[i][1];
            int x2 = coordinates[i+1][0] -coordinates[i][0];
            if (y1*x2 != y2*x1) {
                return false;
            }
        }
        return true;
    }
}
