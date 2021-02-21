package leetcode.贪心;

public class Leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] help = new int[flowerbed.length+2];
        help[0] = 0;
        help[help.length-1] = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            help[i+1] = flowerbed[i];
        }
        for (int i = 1;i<help.length-1;i++){
            if(help[i-1]==0&&help[i]==0&&help[i+1]==0){
                help[i]=1;
                n--;
            }
        }
        if(n<=0){
            return true;
        }else return false;
    }
}
