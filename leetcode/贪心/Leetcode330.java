package leetcode.贪心;

public class Leetcode330 {
    public int minPatches(int[] nums, int n) {
        long total = 1;     //定义总的范围
        int res = 0;
        int index = 0;
        while(total<=n) {       //如果总的范围小于等于n 就进入循环
            if(index<nums.length&&nums[index]<=total){
                total = total+nums[index];      //如果当前数在能表示的范围内，那么能当前范围就可以加上这个数
                index++;
            }else{
                total = total*2;        //如果当前数在范围外，说明此时需要以倍数增加 即 1,2,4,8,16
                res++;          //并且插入一个数
            }
        }
        return res;
    }
}
