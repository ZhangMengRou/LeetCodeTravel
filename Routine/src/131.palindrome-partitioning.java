import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 * 切分的每一段，是对称的
 */
class Solution {
    HashMap<Integer,List<List<String>>> map = new HashMap<>();
    int[][] dp ;
    public List<List<String>> partition(String s) {
        dp = new int[s.length()][s.length()];
        for (int i = 0;i<s.length();i++){
            for (int j = i;j>=0;j--){
                if (s.charAt(i)==s.charAt(j)){
                    if (i-j<=2||dp[j+1][i-1]==1){

                        dp[j][i]=1;

                    }
                }

            }
        }
        List<List<String>> ans = new ArrayList<>();
      
        ans =partition(s,0);
        return ans;
    }
    public List<List<String>> partition(String s,int index) {
        
        if (map.containsKey(index)){
            return map.get(index);
        }

        List<List<String>> tmp = new ArrayList<>();

        // if (index==s.length()-1){
        //     String head = s.substring(index, s.length());
        //     List<String> toAdd =new ArrayList<>();
        //         toAdd.add(head);
                
            
        //         tmp.add(toAdd);
        // }
        
        for (int i = 0;i<s.length();i++){

            if (dp[index][i]==1){
            String head = s.substring(index, i+1);
            
            if (i+1==s.length()){
                List<String> toAdd =new ArrayList<>(); 
            toAdd.add(head);
                tmp.add(toAdd);
                
            }else{
                for (List<String> list:partition(s,i+1)){
                    List<String> toAdd =new ArrayList<>(); 
                    toAdd.add(head);
                    toAdd.addAll(list);
                    tmp.add(toAdd);
                }
                
            }
            
            map.put(index, tmp);
            }
            
        }
        return tmp;

        
    }

}

