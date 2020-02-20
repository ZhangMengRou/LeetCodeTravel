/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 * If there exists a solution, it is guaranteed to be unique.
 * 如果存在结果，那结果是唯一的
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0;i<gas.length;i++){
            sum+=gas[i];
            sum-=cost[i];
        }
        if (sum<0){
            return -1;
        }
        
        int ans = 0;
        sum = 0;
        for (int i = 0;i<gas.length;i++){
        
            int appand =gas[i]-cost[i];
            if (sum+appand<0){

                sum = 0;
                ans =i+1;
            }else{
                sum+=appand;
            }
        }
        return ans;

    }
}

