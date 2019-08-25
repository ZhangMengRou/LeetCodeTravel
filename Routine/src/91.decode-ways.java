/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */
class Solution {
    public int numDecodings(String s) {
        if (s.length()<1) return 1;
        if (s.length()==1&&s.charAt(0) != '0') return 1;
        if (s.charAt(0) == '0') return 0;
        int a1 = s.charAt(0) - '0';
        int a2 = s.charAt(1) - '0';
        int add = 0;
        if (a1*10+a2<=26){
            add = numDecodings(s.substring(2, s.length()));
        }
        return numDecodings(s.substring(1, s.length()))+add;
    }
}

