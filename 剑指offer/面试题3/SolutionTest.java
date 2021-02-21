package 剑指offer.面试题3;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    int[] a = {0, 1, 2, 0, 4, 5, 6, 7, 8, 9} ;
    int[] b = {0,1,0};
    int[] c = {2, 3, 1, 0, 2, 5, 3};

    @Test
    public void testSolution1(){
        Solution1 s = new Solution1();
        int num1 = s.findRepeatNumber(a);
        int num2 = s.findRepeatNumber(b);
        int num3 = s.findRepeatNumber(c);
        Assert.assertEquals(0,num1);
        Assert.assertEquals(0,num2);
        Assert.assertEquals(2,num3);
    }

    @Test
    public void testSolution2(){
        Solution2 s = new Solution2();
        int num1 = s.findRepeatNumber(a);
        int num2 = s.findRepeatNumber(b);
        int num3 = s.findRepeatNumber(c);
        Assert.assertEquals(0,num1);
        Assert.assertEquals(0,num2);
        Assert.assertEquals(2,num3);
    }

    @Test
    public void testSolution3(){
        Solution3 s = new Solution3();
        int num1 = s.findRepeatNumber(a);
        int num2 = s.findRepeatNumber(b);
        int num3 = s.findRepeatNumber(c);
        Assert.assertEquals(0,num1);
        Assert.assertEquals(0,num2);
        Assert.assertEquals(2,num3);
    }

    @Test
    public void testSolution4(){
        Solution4 s = new Solution4();
        int num1 = s.findRepeatNumber(a);
        int num2 = s.findRepeatNumber(b);
        int num3 = s.findRepeatNumber(c);
        Assert.assertEquals(0,num1);
        Assert.assertEquals(0,num2);
        Assert.assertEquals(2,num3);
    }
}
