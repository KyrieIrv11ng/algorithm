package leetcode.回溯DFS;

public class Leetcode79 {
    int cols;
    int rows;
    int[][] toward = {{0,-1},{1,0},{0,1},{-1,0}};//四个方向
    boolean[][] visited ;//看这个位置是否已经寻找过
    public boolean exist(char[][] board, String word) {
        if(board.length==0||board[0].length==0||word.length()==0){
            return false;
        }
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if(search(board,word,0,i,j)){   //循环从每一个位置开始
                    return true;    //如果这个位置上全部能匹配到 返回true
                }
            }
        }
        return false; //没有能匹配到的，返回false

    }

    public boolean search(char[][] board, String word,int index,int startx,int starty){
        if(index == word.length()-1){
            return board[startx][starty]==word.charAt(index); //当index等于最后一位且最后一位匹配时，匹配成功，结束递归
        }
        if(board[startx][starty]==word.charAt(index)){
            visited[startx][starty]=true;   //如果匹配到，这个位置选中
            for (int i = 0; i < 4; i++) {   //从上下左右寻找
                int newx = startx + toward[i][0]; //新的x坐标
                int newy = starty + toward[i][1];   //新的y坐标
                if(islegal(newx,newy)&&!visited[newx][newy]){ //判断新的xy是否在区域中，以及新的xy之前是否已经用过
                    if(search(board,word,index+1,newx,newy)){
                        return true;        //匹配到返回true
                    }
                }
            }
            visited[startx][starty] = false;//四个位置都不匹配，状态重置
        }
        return false;
    }

    public boolean islegal(int x,int y){//看xy是否在区域中
        if(x>=0&&x<cols&&y>=0&&y<rows){
            return true;
        }else return false;
    }
}
