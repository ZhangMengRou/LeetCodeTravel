import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 * 我们设x>len/3
 * 则3x>len
 *又x+x+x+c=len 所以必须小于3
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        if (nums.length<2){

            for (int i:nums){
                ans.add(i);
            }
            return ans;
        }
        int num1 = nums[0];
        int num2 = nums[1];
        int count1 = 1;
        int count2 = 1;  
        for (int i = 2;i<nums.length;i++){
            if (num1==num2){
                count1+=count2;
                count2 = 1;
                num2 = nums[i];
                continue;
            }
            if (num1==nums[i]){
                count1++;
                continue;
            }
            if (num2==nums[i]){
                count2++;
                continue;
            }
            if (count1==0){
                num1=nums[i];
                count1 = 1;
                continue;
            }
            if (count2==0){
                num2=nums[i];
                count2 = 1;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;  
        for (int i = 0;i<nums.length;i++){
            
            if (num1==nums[i]){
                count1++;
                continue;
            }
            if (num2==nums[i]){
                count2++;
                continue;
            }
        }
        if (count1>nums.length/3){
            ans.add(num1);
        }
        if (count2>nums.length/3){
            ans.add(num2);
        }
        return ans;

    }
}
// @lc code=end

