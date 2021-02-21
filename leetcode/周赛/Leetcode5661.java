package leetcode.周赛;

public class Leetcode5661 {
    public static String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            if(time.charAt(i)!='?'){
                sb.append(time.charAt(i));
            }else{
                if(i==0){
                    if(time.charAt(1)=='?'||time.charAt(1)<'4'){
                        sb.append('2');
                    }else{
                        sb.append('1');
                    }
                }else if(i==1){
                    if(time.charAt(0)=='?'||time.charAt(0)=='2'){
                        sb.append('3');
                    }else{
                        sb.append('9');
                    }
                }else if(i==3){
                    sb.append('5');
                }else if(i==4){
                    sb.append('9');
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "??:??";
        System.out.println(maximumTime(s));
    }
}
