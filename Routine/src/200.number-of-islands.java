

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    char[][] myMap;
    char color = '2';
    public int numIslands(char[][] grid) {
        int ans = 0;
        if (grid.length<1||grid[0].length<1){
            return 0;
        }
        myMap = grid;
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                
                if (myMap[i][j]=='1'){
                    // System.out.println(myMap[i][j]);
                    color(i,j,color);
                   
                    
                    ans++;
                }

            }
        }
        
        return ans;
    }
    public void color(int i,int j,char color){
        if (i<0||j<0||i>=myMap.length||j>=myMap[0].length||myMap[i][j]!='1'){
            return;
        }

        myMap[i][j] = color;
        color(i+1,j,color);
        color(i-1,j,color);
        color(i,j+1,color);
        color(i,j-1,color);

    }
}
// @lc code=end

