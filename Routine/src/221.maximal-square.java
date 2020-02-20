/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length<1||matrix[0].length<1){
            return 0;
        }
        int max = 0;
        int[][] count  = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1;i<=matrix.length;i++){
            for (int j = 1;j<=matrix[0].length;j++){
                if (matrix[i-1][j-1]=='1'){
                    count[i][j] = Math.min(count[i-1][j-1],Math.min(count[i-1][j], count[i][j-1]))+1;
                
                    max = Math.max(count[i][j], max);
                }
                
            }
            
        }
        return max*max;
    }
}
// @lc code=end

