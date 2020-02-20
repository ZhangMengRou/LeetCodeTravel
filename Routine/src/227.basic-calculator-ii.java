import java.util.Stack;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 * 除去无用字符串
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();

        s = s.replaceAll(" ", "");
        // System.out.println(s);
        Stack<Character> cStack = new Stack<>();
        int left = 0;
        int i = 0;
        while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
            left = left*10+s.charAt(i)-'0';
            i++;
        }
        nums.push(left);
        for (;i<s.length();i++){
            
            
            char c = s.charAt(i);
            i++;
            int right = 0;
            while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                right = right*10+s.charAt(i)-'0';
                i++;
            }
            i--;

            if (c=='+'||c=='-'){
                cStack.push(c);
                nums.push(right);
            //    System.out.println(c);
                
                continue;
            }
            if (c=='*'||c=='/'){
                int a = nums.pop();
                int b = right;
                // System.out.println("A"+a);
                // System.out.println("B"+b);

                if (c == '*'){
                    nums.push(a*b);
                }else{
                    nums.push(a/b);
                }
                continue;
            }
            
        }
        Stack<Integer> nums2 = new Stack<>();

        Stack<Character> cStack2 = new Stack<>();
        while(!nums.isEmpty()){
            nums2.push(nums.pop());
        }
        while(!cStack.isEmpty()){
            cStack2.push(cStack.pop());
        }
        while(!cStack2.isEmpty()){
            char c = cStack2.pop();
            int a = nums2.pop();
            int b = nums2.pop();

           // System.out.println(a);
          //  System.out.println(b);
            if (c=='+'){
                nums2.push(a+b);
            }else{
                nums2.push(a-b);

            }
        }
        return nums2.pop();

    }
}
// @lc code=end

