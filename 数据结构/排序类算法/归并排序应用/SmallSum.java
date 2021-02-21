package 数据结构.排序类算法.归并排序应用;

public class SmallSum {
    public static int smallSum(int[] nums){
        if(nums==null||nums.length < 2){
            return 0;
        }
        return sortProcess(nums,0, nums.length-1);
    }

    public static int sortProcess(int[] nums,int left,int right){
        if(left==right){
            return 0;
        }
        int mid = left+((right-left)>>1);
        int leftres = sortProcess(nums,left,mid);
        int rightres = sortProcess(nums,mid+1,right);
        int mergeres = merge(nums,left,right,mid);
        return leftres+rightres+mergeres;
    }

    public static int merge(int[] nums,int left,int right,int mid){
        int[] help = new int[right-left+1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        int res = 0;
        while(p1<=mid&&p2<=right){
            res = nums[p1]<nums[p2]?nums[p1]*(right-p2+1)+res: res;
            help[i++] = nums[p1]<nums[p2]?nums[p1++]:nums[p2++];
        }
        while(p1<=mid){
            help[i++] = nums[p1++];
        }
        while(p2<=right){
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[left+j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,3,4,2,5};
        System.out.println(smallSum(a));
    }
}
