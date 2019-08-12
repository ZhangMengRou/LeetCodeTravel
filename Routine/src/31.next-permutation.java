import java.util.HashMap;



/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 * 求下一个大的全排列。。看成求下一个大的拼接的数字了qaq
 */
class Solution {
    public void nextPermutation(int[] nums) {
        
        int index = nums.length-1;
        while(index>0){

            
            if (nums[index-1]<nums[index]){

                
                int k = index-1;
                while(index<nums.length&&nums[k]<nums[index]){
                   
                    index++;
                }
                int tmp = nums[index-1];
                nums[index-1] = nums[k];
                nums[k] = tmp;
                index = k+1;
                break;
            }
            index--;

        }
        swap(nums, index, nums.length-1);

    }
    public void swap(int[] nums,int left ,int right) {
        while(left<=right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;

        }
    }
}

