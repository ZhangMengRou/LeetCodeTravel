import java.util.Arrays;

/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    public int[][] dp ;

    public NumMatrix(int[][] matrix) {
        if (matrix.length<1||matrix[0].length<1) return;
        dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i =0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                dp[i+1][j+1] = dp[i+1][j]+dp[i][j+1]-dp[i][j]+matrix[i][j];
            
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int s1 = dp[row1][col1];
        int s2 = dp[row1][col2+1];
        int s3 = dp[row2+1][col1];
        int s4 = dp[row2+1][col2+1];
        // System.out.println(s1);
        // System.out.println(s2);
        // System.out.println(s3);
        // System.out.println(s4);
        // System.out.println("---");

        return s4-s2-s3+s1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

