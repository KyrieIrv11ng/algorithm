package leetcode;

public class Leetcode11 {
    //暴力法
    public int maxArea(int[] height) {
        if(height.length==0||height.length==1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                max = Math.max(max,Math.min(height[j],height[i])*(j-i));
            }
        }
        return max;
    }

    //双指针
    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

}
