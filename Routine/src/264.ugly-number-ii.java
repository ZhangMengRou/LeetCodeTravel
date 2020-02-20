/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        if (n<1) return 0;
        int[] nums = new int[n];
        nums[0] = 1;
        int i2 =0,i3=0,i5=0;
        int num2 = 2,num3 = 3,num5 = 5;
        for(int i = 1;i<n;i++){
            // 2,3,5,4,9
            int min = Math.min(Math.min(num2,num3),num5);
            nums[i]=min;
           
            if (min==num2){
                i2++;
                num2 = 2*nums[i2];
            }
            if(min==num3){
                i3++;
                num3 = 3*nums[i3];
            }
            if(min==num5){
                i5++;
                num5 = 5*nums[i5];
            }
        }
        return nums[n-1];
        
    }
}
// @lc code=end

