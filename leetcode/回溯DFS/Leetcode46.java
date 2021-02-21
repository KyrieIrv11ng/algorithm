package leetcode.回溯DFS;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(result,l,nums,0,used);
        return result;
    }

    public static void helper(List<List<Integer>> result,List<Integer> l,int[] nums,int index,boolean[] used){

        if(nums.length==index){
            result.add(new ArrayList<>(l));//注意这里如果直接传入l的话传入的是地址，必须做一次拷贝
            System.out.println(new ArrayList<>(l).toString());
        }else{
            for(int i = 0;i<nums.length;i++){//此步骤是为了看数组中是否有之前用过的数
                if(!used[i]){
                    l.add(nums[i]);
                    used[i]=true;
                    helper(result,l,nums,index+1,used);
                    l.remove(index); //回溯
                    used[i]=false;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> permute = permute(a);
    }
}
