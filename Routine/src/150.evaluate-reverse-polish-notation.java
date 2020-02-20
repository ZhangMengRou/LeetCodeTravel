
import java.util.Stack;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s1 = new Stack<>();
        int ans = 0;        
        for (int i = 0;i<tokens.length;i++){
            String c = tokens[i];
            switch(c){
                case "+":
                ans = s1.pop()+s1.pop();
                break;
                case "-": 
                int a = s1.pop();
                int b = s1.pop();
                ans = b-a;
                break;
                case "*":
                ans = s1.pop()*s1.pop();
                break;
                case "/":
                int x = s1.pop();
                int y = s1.pop();
                ans = y/x;
                break;
                default:
                ans = Integer.valueOf(c);
                break;
            }
            s1.add(ans);
        }
        return ans;
    }
}
// @lc code=end

