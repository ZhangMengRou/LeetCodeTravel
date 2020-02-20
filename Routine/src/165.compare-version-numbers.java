/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        
        int i1 = 0;
        int i2 = 0;
        while(i1<version1.length()||i2<version2.length()){
            if (i1<version1.length()&&version1.charAt(i1)=='.') i1++;
            if (i2<version2.length()&&version2.charAt(i2)=='.') i2++;
            int sum1 = 0;
            int sum2 = 0;
            while(i1<version1.length()&&version1.charAt(i1)!='.'){
                sum1=sum1*10+(version1.charAt(i1)-'0');
                i1++;
            }
            while(i2<version2.length()&&version2.charAt(i2)!='.'){
                sum2=sum2*10+(version2.charAt(i2)-'0');
                i2++;
            }
            if (sum1>sum2){
                return 1;
            }
            if (sum1<sum2){
                return -1;
            }

        }
        return 0;
    }
}
// @lc code=end

