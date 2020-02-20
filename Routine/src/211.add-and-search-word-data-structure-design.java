import java.util.HashSet;

/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class TrieNode{
    public boolean end = false;
    public TrieNode[] child = new TrieNode[26];
    public TrieNode() {        
    }
}
class WordDictionary {
    HashSet all = new HashSet<>();
    

    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {
        
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        all.add(word);
        TrieNode head = root;
        
        for (char i :word.toCharArray()){

            int k = i-'a';
            if (head.child[k]==null)
            {
                head.child[k] = new TrieNode();
            }
            head = head.child[k];
       
        }
        head.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (all.contains(word)){
            return true;
        }
        TrieNode head = root;
        return search(word,head,0);
        
    }
    private boolean search(String word,TrieNode root,int index) {
        

        if (word.length()==index&&root.end){
            return true;
        }
        TrieNode head = root;
        for (;index<word.length();index++){
        char i =word.charAt(index);
            if (i=='.'){
                boolean ans = false;
                for (int x = 0;x<26;x++){
                    if (head.child[x]!=null){
                        ans = ans||search(word,head.child[x],index+1);
                    }
                }
                return ans;
            }

            int k = i-'a';
            if (head.child[k]==null){
                return false;
            }
            
            head = head.child[k];
        }
        return head.end==true;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

