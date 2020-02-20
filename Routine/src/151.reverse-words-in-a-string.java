/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // all reverse
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, tmp);
            left++;
            right--;
        }
        int start = 0;
        while(start<sb.length()&&sb.charAt(start)==' '){
                
            sb.deleteCharAt(start);
            

        }
        if (sb.length()<2) return sb.toString();
        for (int i = 0;i<s.length();i++){

            left = i;
            while(i<sb.length()&&sb.charAt(i)!=' '){
                i++;
            }
            right = i-1;
            // reverse
            while(left<right){
                char tmp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, tmp);
                left++;
                right--;
            }
            while(i<sb.length()-1&&sb.charAt(i)==' '&&sb.charAt(i+1)==' '){
                
                sb.deleteCharAt(i);

            }
            
        }
        if (sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();

        
    }
}
// @lc code=end

