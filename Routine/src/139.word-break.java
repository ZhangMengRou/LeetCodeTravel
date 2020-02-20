import java.util.*;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.length()<1){
            return false;
        }
        int[] dp = new int[s.length()+1];
        HashSet<String> set = new HashSet();
        for (String s1:wordDict){
            set.add(s1);
        }
        for(int i = 0;i<s.length();i++){
            for (int j = 0;j<=i;j++){

              //  System.out.println(j+"--"+dp[j]+s.substring(j,i+1));
                if ((j==0||dp[j]==1)&&(
                    set.contains(s.substring(j,i+1)))){
                    dp[i+1]=1;
                //    System.out.println(i);
                    break;
                }
            }
        }
        return dp[s.length()]==1;
        
    }
}
//"leetcode" \n["leet","code"]

