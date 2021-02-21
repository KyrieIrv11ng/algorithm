package 算法作业.test1_17;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int[] nums = new int[sc.nextInt()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            BubbleSort(nums);
            for (int i = 0; i < nums.length; i++) {
                if(i==0){
                    System.out.print(nums[i]);
                }else{
                    System.out.print(" "+ nums[i]);
                }
            }
        }
    }

    public static void BubbleSort(int[] nums){
        for(int i = nums.length-1;i>0;i--){
            for(int j = 0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
