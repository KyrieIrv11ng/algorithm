package leetcode.滑动窗口;

public class Leetcode1423 {
    //滑动窗口，左窗口和右窗口，找最大值
    public int maxScore(int[] cardPoints, int k) {
        int left = k-1;
        int right = cardPoints.length-1;
        int sum =0;
        for (int i = 0; i < k; i++) {
            sum = sum + cardPoints[i];
        }
        int max = sum;
        while(left>=0){
            sum = sum +cardPoints[right]-cardPoints[left];
            max = Math.max(max,sum);
            left--;
            right--;
        }
        return max;
    }
}
