package leetcode;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int rest = 0;
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum = gasSum + gas[i];
            costSum = costSum + cost[i];
            rest = rest + (gas[i] - cost[i]);
            if(rest<min){
                min = rest;
                index = i;
            }
        }
        if(gasSum<costSum){
            return -1;
        }else return (index+1)%gas.length;
    }
}
