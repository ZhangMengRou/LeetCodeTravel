import java.util.HashSet;

/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */
// 标记为1的地方为不能通过的障碍
class Solution {
    // dp 不使用多余空间 每个格子由他的左边和上边相加得到
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null||obstacleGrid.length<1){
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1) return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1;i<n;i++){

            obstacleGrid[i][0] = obstacleGrid[i][0]==1?0:obstacleGrid[i-1][0];
        }
        for (int i = 1;i<m;i++){

            obstacleGrid[0][i] = obstacleGrid[0][i]==1?0:obstacleGrid[0][i-1];
        }
        for (int i = 1;i<n;i++){
            for (int j = 1;j<m;j++){

                obstacleGrid[i][j] = obstacleGrid[i][j]==1?0:obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[n-1][m-1];
    }
    
}

