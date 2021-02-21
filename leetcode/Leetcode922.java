package leetcode;

public class Leetcode922 {
    public int[] sortArrayByParityII(int[] A) {
        int less = -1;
        int more = A.length;
        int left = 0;
        while(left<more){
            if(A[left]%2==1){
                swap(A,++less,left++);
            }else{
                swap(A,--more,left);
            }
        }

        int leftt = 0;
        int right = A.length-1;
        while(leftt<right){
            swap(A,leftt,right);
            leftt = leftt+2;
            right = right-2;
        }
        return A;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
