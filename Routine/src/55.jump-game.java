/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */
class Solution {
    public boolean flag = false;
    // 寻找过一次的标记
    int[] mark;
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length<2){
            return true;
        }
        mark = new int[nums.length];
        int lastIndex = nums.length-1;
        canJump(nums,lastIndex);
        return flag;
    }
    public void canJump(int[] nums,int right) {
        if (right<=0){
            flag =  true;
        }
        for (int i = right-1;i>=0;i--){
            if (flag){
                return;
            }
            if (nums[i]>0&&right-i<=nums[i]&&mark[i]==0){
                canJump(nums, i);
                if (!flag){
                    mark[i] = 1;
                }
            }
        }
        
        
    }
}
//[
    // 2,0,6,9,8,4,5,0,8,9,
    // 1,2,9,6,8,8,0,6,3,1,
    // 2,2,1,2,6,5,3,1,2,2,
    // 6,4,2,4,3,0,0,0,3,8,
 //   2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6]

// Actual
