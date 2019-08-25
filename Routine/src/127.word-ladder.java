import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 * 从字母只有26个这个角度出发
 * 列表无重复
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = 1;
        HashSet<String> left = new HashSet<>();
        for (int i = 0;i<wordList.size();i++){
            left.add(wordList.get(i));
        }
        if (!left.contains(endWord)){
            return 0;
        }
        if (beginWord.equals(endWord)){
            return 1;
        }
        left.remove(endWord);
        HashSet<String> b = new HashSet<>();
        HashSet<String> e = new HashSet<>();

        b.add(beginWord);
        e.add(endWord);
        boolean flag = true;
        while(flag){
            if (e.size()<b.size()){
                HashSet tmp = e;
                e = b;
                b = tmp;
            }
            int addNum = 0;
            List<String> sLiStrings = new ArrayList<>(b);
            for (String s :sLiStrings){
                
                for (int index = 0;index<s.length();index++){
                    StringBuffer tmp = new StringBuffer(s);
                    for (int i = 0;i<26;i++){
                        if ('a'+i!=s.charAt(index)){
                            char a = (char)('a'+i);
                            tmp.setCharAt(index, a);

                            if (e.contains(tmp.toString())){
                                return len+1;
                            }
                            if (left.contains(tmp.toString())){
                                addNum++;
                                b.add(tmp.toString());
                               // System.out.println(tmp.toString());
                                left.remove(tmp.toString());
                            }
                        }
                    }
                }
            }
            if (addNum==0){
                // System.out.println(b.toString());
                // System.out.println(e.toString());
                // System.out.println(left.size());
                
                return 0;
            }
            len++;
        }
        return len;
        
    }
}

