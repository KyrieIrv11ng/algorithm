package leetcode.双指针;

public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length-1;
        while(head<tail){
            int sum = numbers[head]+numbers[tail];
            if(sum==target){
                return new int[]{head+1,tail+1};
            }else if(sum>target){
                tail--;
            }else{
                head++;
            }
        }
        return new int[]{-1,-1};
    }
}
