/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length()<3){
            return false;
        }
        boolean ans = false;
        for (int i = 1;i< num.length()-1;i++){
            for (int j = i+1;j<num.length();j++){
                ans = ans||isAdditiveNumber(num.substring(j, num.length()),
                 Integer.valueOf(num.substring(0, i)), Integer.valueOf(num.substring(i, j)));
            }
        }
        return ans;
        
    }
    public boolean isAdditiveNumber(String num,int left,int right) {

        if (num.length()==0){
            return false;
        }
        int sum = left+right;
        String sumS = sum+"";
        System.out.println(num+"--"+sumS);

        if (num.startsWith(sumS)){
         //   System.out.println(num+"--"+sumS);
            if (num.equals(sumS)){
                return true;
            }
            return isAdditiveNumber(num.substring(sumS.length(),num.length()),
            right,sum);
        }else{
            return false;
        }

    }
}
// @lc code=end

