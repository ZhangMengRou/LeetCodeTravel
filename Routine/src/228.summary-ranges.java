import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length<1) {
            return ans;
        }
        
        for (int i = 0;i<nums.length;i++){
            int start = nums[i];
            int end = start;
            i++;
            while(i<nums.length&&nums[i]==end+1){
                end++;
                i++;
            }
            i--;
            if (end==start){
                ans.add(end+"");
            }else{
                ans.add(start+"->"+end);
            }

        }
        return ans;
        
    }
}
// @lc code=end

