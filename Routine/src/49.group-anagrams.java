
import java.util.ArrayList;
import java.util.HashMap;


/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] count = new int[strs.length][26];
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        List<List<String>> ans = new ArrayList<List<String>>();
        for (int i = 0;i<strs.length;i++){

            String s = strs[i];
            StringBuffer sb = new StringBuffer();
            for (int j = 0;j<s.length();j++){
                count[i][s.charAt(j)-'a']++;
                // switch (s.charAt(j)){
                //     case 'a':
                //     count[i][0]++;
                //     break;
                //     case 'e':
                //     count[i][1]++;                    
                //     break;
                //     case 'i':
                //     count[i][2]++;
                //     break;
                //     case 'o':
                //     count[i][3]++;
                //     break;
                //     case 'u':
                //     count[i][4]++;
                //     break;
                // }
            }
            for (int k = 0;k<26;k++){
                sb.append(count[i][k]+",");
            }
            List<String> list =  map.getOrDefault(sb.toString(),new ArrayList<>());
            list.add(s);
            map.put(sb.toString(),list);
        }
        Iterator iter = map.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry entry = (Map.Entry) iter.next(); 
            List<String> add = (List<String>)entry.getValue();
            ans.add(add);
        }
        
        return ans;
    }
}

