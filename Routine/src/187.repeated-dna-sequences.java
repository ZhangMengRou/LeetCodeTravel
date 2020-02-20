import java.util.*;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int p = (int)Math.pow(5, 9);
        List<String> ans = new ArrayList<String>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ansSet = new HashSet<>();

        if (s.length()<10) return ans;
        int sum = 0;
        for (int i = 0;i<10;i++){

            int count = count(s.charAt(i));
            sum = sum*5+count;
        }
        set.add(sum);
        int start = 0;
        for (int i = 10;i<s.length();i++){
            int count = count(s.charAt(i));
            start++;
            sum = (sum%p)*5+count;
            if(set.contains(sum)&&!ansSet.contains(sum)){
                ans.add(s.substring(start, i+1));
                ansSet.add(sum);
            }
            set.add(sum);
            
        }

        return ans;

        
    }
    public int count(char c){
        switch(c){
            case 'A':
            return 4;
            case 'C':
            return 1;
            case 'G':
            return 2;
            case 'T':
            return 3;
            default:
            return 0;
        }
    }
}
// @lc code=end

