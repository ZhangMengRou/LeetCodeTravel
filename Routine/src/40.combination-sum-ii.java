import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javafx.print.Collation;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<candidates.length;i++){
            map.put(candidates[i], 
            map.getOrDefault(candidates[i], 0)+1);
           
        }
        combinationSum2( map, target,new ArrayList<>());
        return ans;
        
    }
    public void combinationSum2(TreeMap<Integer,Integer> map, int target,List<Integer> list) {
        
        if (target==0){
            
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if (map.isEmpty()){

            return;
        }
        int k = map.firstKey();
        int count = map.get(k);
        List<Integer> listAdd = new ArrayList<>();
        
        map.remove(k);

        for (int i = 0;i<=count&&target-k*i>=0;i++){
            list.addAll(listAdd);
            combinationSum2(map,target-k*i,list);
            listAdd.add(k);
            list.removeAll(listAdd);
        }
        map.put(k,count);
        
    }
}

