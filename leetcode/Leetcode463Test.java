package leetcode;

import org.junit.Test;

public class Leetcode463Test {
    @Test
    public void test(){
        Leetcode463 l = new Leetcode463();
        int[][] a = {{1,1}};
        int[][] b = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        l.islandPerimeter(a);
        l.islandPerimeter(b);
    }
}
