import java.util.ArrayList;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[]  len = new int[n+1];
        ArrayList list = new ArrayList<>();
        int a = 1;
        for (int i = 1;i<=n;i++){
            a =a *i;
            len[i] = a; 
            list.add(i);
        }
        StringBuilder ans = new StringBuilder();
        int left = k;
        
   
        for (int i = n-1;i>=1&&left>0;i--){

            int tmp = (left)/len[i]-1;
            left = left%len[i];
            if (left !=0) tmp++;
          //  System.out.print(tmp);
            ans.append(list.get(tmp));
            list.remove(tmp);
        }
        for (int i=list.size()-1;i>=0;i--){
            ans.append(list.get(i));
        }
        
        return ans.toString();
        
    }
}

