package leetcode.双指针;

public class Leetcode925 {  //我的code

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        if(name.length() == typed.length() &&name.equals(typed)){
            return true;
        }

        if(typed.length() < name.length()){
            return false;
        }

        while(j < typed.length()&& i <name.length()){
            if(name.toCharArray()[i]==typed.toCharArray()[j]){
                i++;
                j++;
            }else if(name.toCharArray()[i]!=typed.toCharArray()[j]&&i==0){
                return false;
            }else if(name.toCharArray()[i]!=typed.toCharArray()[j]&&name.toCharArray()[i-1]==typed.toCharArray()[j]){
                j++;
            }else return false;
        }
        if(i==(name.length()-1)){
            return false;
        }
        if(name.toCharArray()[name.length()-1]!=typed.toCharArray()[typed.length()-1]){
            return false;
        }
        return true;
    }
    /*
    官方解答：双指针
        根据题意能够分析得到：字符串 \textit{typed}typed 的每个字符，有且只有两种「用途」：

        作为 \textit{name}name 的一部分。此时会「匹配」\textit{name}name 中的一个字符

        作为长按键入的一部分。此时它应当与前一个字符相同。

        如果 \textit{typed}typed 中存在一个字符，它两个条件均不满足，则应当直接返回 \textit{false}false；否则，当 \textit{typed}typed 扫描完毕后，我们再检查 \textit{name}name 的每个字符是否都被「匹配」了。

        实现上，我们使用两个下标 i,ji,j 追踪 \textit{name}name 和 \textit{typed}typed 的位置。

        当 \textit{name}[i]=\textit{typed}[j]name[i]=typed[j] 时，说明两个字符串存在一对匹配的字符，此时将 i,ji,j 都加 11。

        否则，如果 \textit{typed}[j]=\textit{typed}[j-1]typed[j]=typed[j−1]，说明存在一次长按键入，此时只将 jj 加 11。

        最后，如果 i=\textit{name}.\textit{length}i=name.length，说明 \textit{name}name 的每个字符都被「匹配」了。

     */
    public boolean isLongPressedName1(String name, String typed) {

        int i = 0, j = 0;
        while (j < typed.length()) {    //以j为主要指针移动
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;   //只要不和前面一个相等,且不匹配name中的字符,就匹配失败
            }
        }
        return i == name.length(); //i如果等于name.length 则匹配成功
    }

}
