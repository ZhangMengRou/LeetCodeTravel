import java.util.Arrays;

/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length+1];
        int count = 0;
        sum[0] = 0;
        for (int i = 1;i<sum.length;i++){
            
            count+=nums[i-1];
            sum[i] = count;
        }
       // System.out.println(Arrays.toString(sum));
        int min = nums.length+1;
        for (int i = 0;i<sum.length;i++){
            int sumMax = sum[i]+s;
            // System.out.println(sumMax);
            int k = Arrays.binarySearch(sum, sumMax);
            // System.out.println("k:  "+k);
            if (k<0) k = -k-1;
            // System.out.println(k);
            if (k>=sum.length){
                continue;
            }
            min = Math.min(k-i, min);
        }
        return min==nums.length+1?0:min;
        
    }
}
/*
11\n
[1,2,3,4,5]
*/
// @lc code=end

