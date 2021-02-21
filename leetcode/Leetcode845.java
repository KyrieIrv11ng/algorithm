package leetcode;

import java.util.ArrayList;

public class Leetcode845 {
    //自己的方法
    public int longestMountain(int[] A) {
        int result = 0;
        int maxnum = 0;
        if(A.length<3 ){
            return 0;
        }
        ArrayList<Integer> maxnumlist = new ArrayList<>(); //创建最大值list
        ArrayList<Integer> maxnresultlist = new ArrayList<>();  //创建结果值list
        for(int i = 0;i<A.length;i++){          //找出中间值大于两边值的数
            if(i>0&&i<A.length-1){
                if(A[i]>A[i-1]&&A[i]>A[i+1]){
                    maxnum = i;                    //能找到的话最少就有三个
                    result = 3;
                    maxnumlist.add(maxnum);
                }
            }else continue;
        }
        if(maxnum==0){
            return 0;               //找不到直接返回0
        }
        for(int i = 0;i < maxnumlist.size();i++){
            result = 3;
            maxnum = maxnumlist.get(i);
            int numleft = maxnum-1;
            int numright = maxnum+1;
            while(numleft>0||numright<A.length-1){
                if(numleft>0&&A[numleft]>A[numleft-1]){ //有比左边数还要小的 索引减一
                    result++;
                    numleft--;
                }
                if(numright<A.length-1&&A[numright]>A[numright+1]){ //有比右边数还要大的 索引加一
                    result++;
                    numright++;
                }
                if((numleft>0&&numright<A.length-1&&A[numleft]<=A[numleft-1]&&A[numright]<=A[numright+1])
                        ||(numleft==0&&numright!=A.length-1&&A[numright]<=A[numright+1])
                        ||(numleft!=0&&numright==A.length-1&&A[numleft]<=A[numleft-1])){
                    break;
                }
            }
            maxnresultlist.add(result);

        }
        int max = 0;
        for (Integer integer : maxnresultlist) {
            max = Math.max(max,integer);
        }
        return max;
    }
}
