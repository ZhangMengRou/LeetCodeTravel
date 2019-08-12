import java.util.HashMap;
import java.util.HashSet;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    HashMap<Integer,HashSet<Integer>> mapRow = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> mapColumn = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> mapSquare = new HashMap<>();
    HashMap<Integer,HashSet<Integer>> mapIndex = new HashMap<>();
    boolean ans = false;

    public boolean isValidSudoku(char[][] board) {
        if (board==null||board.length!=9||board[0].length!=9){
            
            return false;
        }
       

        // 初始化
        for (int i = 0;i<9;i++){
            mapRow.put(i, new HashSet());
            mapColumn.put(i, new HashSet());
        }
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                mapSquare.put(i*10+j, new HashSet());
            }
        }
        for (int i = 0;i<9;i++){
            for (int j = 0;j<9;j++){
                if (board[i][j]!='.'){
                    int k = board[i][j]-'0';
                    if (mapRow.get(i).contains(k)){
                        return false;
                    }
                    mapRow.get(i).add(k);
                    if (mapColumn.get(j).contains(k)){
                        return false;
                    }
                    mapColumn.get(j).add(k);
                    if (mapSquare.get(i/3*10+j/3).contains(k)){
        
                        return false;
                    }
                    mapSquare.get(i/3*10+j/3).add(k);
                }
            }
        }

       // char[][] boardCopy = board;
       // check(boardCopy, 0, 0);

        return true;

        
    }
    /*
    这部分为数独的解法
    */
    public void check(char[][] boardCopy, int i, int j) {
        if (i>8||j>8){
            return;
        }
        if (boardCopy[i][j]!='.'){
            if (i == 8 && j == 8) {
                ans = true;
                return;
            }
            if (j != 8) {
                check(boardCopy, i, j + 1);
            } else {
                check(boardCopy, i + 1, 0);
            }
            
        }
        HashSet<Integer> set = new HashSet<>();
        set.addAll(mapRow.get(i));
        set.addAll(mapColumn.get(j));
        set.addAll(mapSquare.get(i / 3 * 10 + j / 3));
        
        if (set.size() == 10) {
            return;
        }
        if (i == 8 && j == 8) {
            ans = true;
        }
        for (int k = 0; k < 10; k++) {
            if (!set.contains(k)) {
                mapRow.get(i).add(k);
                mapColumn.get(j).add(k);
                mapSquare.get(i / 3 * 10 + j / 3).add(k);
                if (j != 8) {
                    check(boardCopy, i, j + 1);
                } else {
                    check(boardCopy, i + 1, 0);
                }
                mapRow.get(i).remove(k);
                mapColumn.get(j).remove(k);
                mapSquare.get(i/3*10+j/3).remove(k);
                // System.out.println("i"+i+"j:"+j);
                // System.out.println(k);

                if (ans) return;
            }
            
        }
    }
}

