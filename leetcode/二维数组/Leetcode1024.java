package leetcode.二维数组;

public class Leetcode1024 {
    public int videoStitching(int[][] clips, int T) {
        int last = 0; //当前最长的区间右端点
        int pre = 0; //上一个被使用子区间的右端点
        int result = 0;
        int[] maxn = new int[T];
        for (int[] clip : clips) {
            if(clip[0]<T){
                maxn[clip[0]] = Math.max(clip[1],maxn[clip[0]]);
            }
        }

        for (int i = 0; i < T; i++) {
            last = Math.max(last,maxn[i]); //每次更新最长的last
            if(i==last){     //假如，[1,10]当前最长序列到5,但是到5这个点
                return -1;   // last没有更新，还是5，说明这个点是断点
                             // 没有连接起来，返回-1
            }
            if(i==pre)  {
                result++;
                pre = last;     //如果last更新了，并且比之前last还要大
                                // 检查是否包含在前面的子区间内，有就更新子区间的右端点
            }
        }
        return result;
    }
}
