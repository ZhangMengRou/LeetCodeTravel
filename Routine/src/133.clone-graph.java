import java.util.*;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    // class Node {
    //     public int val;
    //     public List<Node> neighbors;
    
    //     public Node() {}
    
    //     public Node(int _val,List<Node> _neighbors) {
    //         val = _val;
    //         neighbors = _neighbors;
    //     }
    // };
    public HashMap<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        
        
        return clone(node);
    }
    public Node clone(Node node) {
        
        if (node == null) return null;
        if (map.get(node.val)!=null)
        return map.get(node.val);
        
        Node tmp = new Node();
        tmp.val = node.val;
        List<Node> n = new ArrayList<>();
        map.put(tmp.val,tmp);
        tmp.neighbors = n;
        for (Node nNode : node.neighbors){
            n.add(clone(nNode));
        }
        
        
        return tmp;
    }
}

