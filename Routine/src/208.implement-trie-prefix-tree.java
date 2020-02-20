import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class TrieNode{
    public char val;
    public TrieNode[] child = new TrieNode[26];
    public TrieNode() {        
    }
}
class Trie {
    HashSet all = new HashSet<>();
    

    TrieNode root = new TrieNode();
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return all.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (all.contains(prefix)){
            return true;
        }
        TrieNode head = root;
        for (char i :prefix.toCharArray()){

            int k = i-'a';
            if (head.child[k]==null){
                return false;
            }
            
            head = head.child[k];
        }
        return true;
    }
}
/*
["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]\n
[[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

