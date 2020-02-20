/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    // 变相冒泡
    public String largestNumber(int[] nums) {
        for (int i = 0;i<nums.length;i++){
            int maxIndex = i;
            for (int j = i+1;j<nums.length;j++){
                if (!isMaxAB(nums[maxIndex], nums[j])){
                    maxIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = tmp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<nums.length;i++){
            
            sb.append(nums[i]+"");
        }
        while(sb.length()>1&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public boolean isMaxAB(int a ,int b){
        String ab = a+""+b;
        String ba = b+""+a;

        if (Long.valueOf(ab)>=Long.valueOf(ba)){
           // System.out.println(Integer.valueOf(ab));
            return true;
        }
        else{
            return false;
        }
    }
}
// @lc code=end

