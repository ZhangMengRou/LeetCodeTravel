import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */
class Solution {
    List<List<Integer>>  ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if (nums==null){
            return ans;
        }
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>());
        return ans;
        
    }
    public void subsetsWithDup(int[] nums,int index,List<Integer> list) {
        System.out.print(index+"--"+list);
        if (index == nums.length){
          //  System.out.print(index+"-add-"+list);
            List<Integer> add = new ArrayList<>(list);
            
            ans.add(add);
            return;
        }
        
            
            int count = 0;
            int c = nums[index];
            while(index<nums.length&&nums[index]==c){
                count++;
                index++;
            }
            for (int i = 0;i<=count;i++){

                List<Integer> tmp = new ArrayList<>(list);
                subsetsWithDup(nums,index,tmp);
                list.add(c);
            }
            // subsetsWithDup(nums,index,list);
        
        
    }
}

