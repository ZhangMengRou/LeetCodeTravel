import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.sun.org.apache.xpath.internal.SourceTree;


/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    HashSet<String> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums==null||nums.length<1) return ans;
        // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // ans.add(list);
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++){
        permuteUnique(nums,i);
    }
        return ans;
    }
    public void permuteUnique(int[] nums,int index) {
        
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // System.out.println(list.toString());
        if (!set.contains(list.toString())){
            
            ans.add(list);
            set.add(list.toString());
        }
            
        if (index==nums.length){
            
            return;
        }
       
        HashSet<Integer> set = new HashSet<>();
        for (int i = index+1;i<nums.length;i++){
            permuteUnique(nums,i);
            if (nums[i]!=nums[index]&&(!set.contains(nums[i]))){

                set.add(nums[i]);
                /*
                全排列顺序
                用链表可以更快
                */
                int tmp = nums[index];
                nums[index] = nums[i];
                
                for (int j = i;j>=index+2;j--){

                    nums[j] = nums[j-1];
                }
                nums[index+1] = tmp;
                permuteUnique(nums,index+1);
                tmp = nums[index];
                for (int j = index;j<=i-1;j++){

                    nums[j] = nums[j+1];
                }
                nums[i] = tmp;
                // nums[index] = tmp;
            }
        }
    }
    
}

