package leetcode;

import org.junit.Test;

public class Leetcode498Test {

    @Test
    public void Test(){
        Leetcode498 l = new Leetcode498();
        int[][] a = {{1, 2, 3 }, {4, 5, 6 }, {7, 8, 9 }};
        int[] b = l.findDiagonalOrder(a);
        for (int i : b) {
            System.out.print(i);
        }

    }
}
