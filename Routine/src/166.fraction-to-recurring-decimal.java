import java.util.HashMap;

/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
class Solution {
    int flag = 0;
    StringBuffer stringBuffer = new StringBuffer();
    HashMap<Long,Integer> map = new HashMap<>();
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0){
            return "0";
        }
        long k = (long)numerator*(long)denominator;
        String s ="";
        if (k<0){

            s = "-";
        }    
        fractionToDecimalPlus(Math.abs((long)numerator),
        Math.abs((long)denominator));
        return s+stringBuffer.toString();
    }
    public void fractionToDecimalPlus(long numerator, long denominator) {
        // System.out.println(denominator);
        if (numerator%denominator==0){
            stringBuffer.append(numerator/denominator+"");
            return;
        }
        if (map.get(numerator)!=null){
            String tail = stringBuffer.substring(map.get(numerator), stringBuffer.length());
            String ans = stringBuffer.substring(0,map.get(numerator)).toString()+"("+tail+")";
            stringBuffer = new StringBuffer(ans);
            return;
        }
        if (numerator<denominator){
            stringBuffer.append(0);
            
        }else{
            
            stringBuffer.append(numerator/denominator+"");
        }
        if (flag==0){
            stringBuffer.append('.');
            flag = 1;
        }
        
        if (flag==1){
            map.put(numerator, stringBuffer.length()-1);
        }
        fractionToDecimalPlus(numerator%denominator*10, denominator);
        
    }
}
// @lc code=end

