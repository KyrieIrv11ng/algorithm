package leetcode;

import java.util.Stack;

public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[matrix[0].length+2];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            Stack<Integer> s = new Stack<>();
            height[0] = 0;
            height[height.length-1] = 0;
            s.push(0);
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]=='1'){
                    height[j+1] ++;
                }else {
                    height[j+1] = 0;
                }
                while(!s.isEmpty()&&height[j+1]<height[s.peek()]){
                    int tmp = s.pop();
                    maxArea = Math.max(maxArea,(j-s.peek())*height[tmp]);
                }
                s.push(j+1);
            }
            System.out.println(s.toString());
            while(!s.isEmpty()&&0<height[s.peek()]){
                int tmp = s.pop();
                maxArea = Math.max(maxArea,(height.length-2-s.peek())*height[tmp]);
            }
        }
        return maxArea;
    }
}
