/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */
class Solution {
    int[][] mark;
    int[][] q ;

    int flag = 0;
    public void solve(char[][] board) {
        
        if(board==null||board.length<1||board[0].length<1){
            return;
        }
    mark = new int[board.length][board[0].length];
        
        for (int i =0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (mark[i][j]==0&&board[i][j]=='O'){

                    flag = 0;
                    q = new int[board.length][board[0].length];
                    solve(board,i,j);
                    if (flag==0){
                        for (int i1 =0;i1<board.length;i1++){
                            for (int j1 = 0;j1<board[0].length;j1++){
                                if (q[i1][j1]==1){
                                    board[i1][j1] = 'X';
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void solve(char[][] board,int i,int j) {
        // System.out.println(i+"--"+j+"--"+mark[i][j]);
        if (board[i][j]=='X'||mark[i][j] == 1) return;
        mark[i][j] = 1;
        if (i-1>=0) solve(board,i-1,j);
        if (i+1<board.length) solve(board,i+1,j);
        if (j-1>=0) solve(board,i,j-1);
        if (j+1<board[0].length) solve(board,i,j+1);
        if (i==0||j==0||i==board.length-1||j==board[0].length-1){
            flag = 1;
        }
        
        q[i][j] = 1;

    }
}

