/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) return 0;
        if (divisor == 1) return dividend;
        int flag = 1;
        if (dividend > 0 && divisor < 0) {
            flag = -1;
        }
        if (dividend < 0 && divisor > 0) {
            flag = -1;
        }
        long dividend1 = dividend==Integer.MIN_VALUE?-(long)Integer.MIN_VALUE:Math.abs(dividend);
        long divisor1 = divisor==Integer.MIN_VALUE?-(long)Integer.MIN_VALUE:Math.abs(divisor);
        long dividendCopy = dividend1;
        long ans = 0;
        Stack<Integer> divNum = new Stack<>();
        while (dividendCopy != 0) {
            divNum.add((int) (dividendCopy % 10));
            dividendCopy = dividendCopy / 10;
        }
        long left = 0;
        while (divNum.size() > 0) {
            left = left * 10 + divNum.pop();
            int count = 0;
            while (left >= divisor1) {
                left = left - divisor1;
                count++;
            }
            ans = ans * 10 + count;
        }

        return ans>Integer.MAX_VALUE?Integer.MAX_VALUE*flag: (int) (ans * flag);

    }
}

