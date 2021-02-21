package leetcode.双指针;

import org.junit.Assert;
import org.junit.Test;

public class Leetcode925Test {
    @Test
    public void test(){
        Leetcode925 l  = new Leetcode925();
        String s1 = "saeed";
        String s2 = "ssaaedd";
        boolean result = l.isLongPressedName(s1,s2);
        Assert.assertEquals(false,result);
    }
}
