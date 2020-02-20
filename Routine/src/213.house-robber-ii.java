/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    
    public int rob(int[] nums) {
        int max = 0;
        if (nums.length<1){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int include = 0;
        int exclude = 0;
        for (int j = 1;j<nums.length;j++){
            int i = include;
            int e = exclude;
            include = e+nums[j];
            exclude = Math.max(i, e);
        }
        max = Math.max(include, exclude);
        include = 0;
        exclude = 0;
        for (int j = 0;j<nums.length-1;j++){
            int i = include;
            int e = exclude;
            include = e+nums[j];
            exclude = Math.max(i, e);
        }
        max = Math.max(include, max);
        max = Math.max(exclude, max);

        return max;
        
    }
    
}
// @lc code=end

