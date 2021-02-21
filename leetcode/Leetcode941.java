package leetcode;

public class Leetcode941 {
    //我的题解
    public boolean validMountainArray(int[] A) {
        int peek = -1;
        if(A.length<3){
            return false;
        }
        for(int i = 1;i<A.length-1;i++){
            if(A[i]>A[i-1]&&A[i]>A[i+1]){
                peek = i;
                break;
            }
        }
        if(peek == -1){
            return false;
        }
        int left = peek-1;
        int right = peek+1;
        while(left>0){
            if(A[left]<=A[left-1]){
                return false;
            }else{
                left--;
            }
        }
        while(right<A.length-1){
            if(A[right]<=A[right+1]){
                return false;
            }else{
                right++;
            }
        }
        return true;
    }
    //官方题解
    //先上山，找到最高点记录元素的位置，再往下走，记录向下走的坐标，直到不符合结束
    public boolean validMountainArray1(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

}
