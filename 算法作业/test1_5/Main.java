package 算法作业.test1_5;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(" ");
            int k = Integer.parseInt(split[0]);
            int[] nums = new int[Integer.parseInt(split[1])];
            int sum = 0;
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(tmp[j]);
                sum = sum + nums[j];
            }
            Arrays.sort(nums);
            int min = nums[nums.length-1];
            int max = sum;
            search(min,max,nums,k);
        }
    }

    public static int getPainter(int value, int[] nums){
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            sum = sum + num;
            if (sum > value) {
                count++;
                sum = num;
            }
        }
        return count;
    }

    public static void search(int start,int end,int[] nums,int k){
        int mid = start + (end-start)/2;
        if(start==end){
            System.out.println(start);
            return;
        }
        if(getPainter(mid,nums)>k){
            start = mid+1;
            search(start,end,nums,k);
        }else{
            end = mid;
            search(start,end,nums,k);
        }
    }
}