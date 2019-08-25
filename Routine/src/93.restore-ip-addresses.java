import java.util.ArrayList;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 * (1~255).(0~255).(0~255).(0~255) ?? 允许0.0.0.0？
 */
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int lenMax = 12;
        int left = lenMax - s.length();
        restoreIpAddresses(s,left,new StringBuilder(),4);

        return ans;
    }
    public void restoreIpAddresses(String s,int left,StringBuilder sb,int leftIndex) {
    //    System.out.println(s+"--"+left+"--"+leftIndex);
        if (left ==0&&leftIndex*3!=s.length()){
            return;
        }
        if (left<0||s.length()==0){
            return;
        }
        if (s.length()==0) return;
        if (leftIndex==1){
            if(s.length()>3){
                return;
            }
            if(s.charAt(0)=='0'&&s.length()!=1){
                return;
            }
            int k = Integer.valueOf(s);
            if (k>=0&&k<=255){
                sb.append(k);
                ans.add(sb.toString());
                return;
            }
            return;
        }
        if (leftIndex<=4){
            if (s.charAt(0)=='0'){
                StringBuilder sbCopy = new StringBuilder(sb.toString());
                    sbCopy.append("0.");
                    restoreIpAddresses(s.substring(1), left-2, sbCopy, leftIndex-1);    
                    return;
            }
            for (int i = 1;i<=s.length()&&i<=3;i++){

                
                int k = Integer.valueOf(s.substring(0, i));
                if (k>=0&&k<=255){
                    StringBuilder sbCopy = new StringBuilder(sb.toString());
                    sbCopy.append(k+".");
                //    System.out.println(sbCopy.toString());
                    restoreIpAddresses(s.substring(i), left-(3-i), sbCopy, leftIndex-1);    
                }
                
            }
            
        }
        
    }
}

