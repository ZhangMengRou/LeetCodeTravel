import java.util.Arrays;

/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        int count =0;
        for (int i = citations.length-1;i>=0;i--){
            while(h>count&&h>citations[i]){
                h--;
            }
            count++;
            if (count >=h){
                return h;
            }
        }
        return h;
        
    }
}
// @lc code=end

