import java.util.HashMap;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 */

// @lc code=start
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<1||t<0){
            return false;
        }
        HashMap<Long,Long> map = new HashMap<>();
        long mod = t+1;
      
        long[] num = new long[nums.length];
        for (int i = 0;i<nums.length;i++){
            num[i] = (long )nums[i]- Integer.MIN_VALUE;
            long m = num[i]/mod;
            if (map.get((long)m)!=null||
            (map.get((long)m-1)!=null&&Math.abs(map.get((long)m-1)-num[i])<=t)||
            (map.get((long)m+1)!=null&&Math.abs(map.get((long)m+1)-num[i])<=t)){
                return true;
            }

            map.put((long)m, (long)num[i]);
            if (map.size()>k){
                map.remove((long)num[i-k]/mod);
            }
        }
        return false;
        
    }
}
// @lc code=end

