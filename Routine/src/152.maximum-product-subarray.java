/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length<1) return 0;
        int ans = nums[0];
        int min = ans;
        int max = ans;
        for (int i = 1;i<nums.length;i++){

            int maxTmp = Math.max(Math.max(min*nums[i], nums[i]), max*nums[i]); 
            int minTmp = Math.min(Math.min(min*nums[i], nums[i]), max*nums[i]); 
        
            max = maxTmp;
            min = minTmp;
            ans = Math.max(ans, max);
        }
        return ans;
    }
    
}
// @lc code=end

