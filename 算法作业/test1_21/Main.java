package 算法作业.test1_21;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            int[] nums = new int[Integer.parseInt(sc.nextLine())];
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(tmp[j]);
            }
            System.out.println(help(nums));
        }
    }
    public static int help(int[] nums) {
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(i<j&&nums[i]>nums[j]){
                    res++;
                }
            }
        }
        return res;
    }
}
