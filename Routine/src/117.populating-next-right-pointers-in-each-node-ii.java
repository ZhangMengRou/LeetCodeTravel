import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        List<Node> list = new ArrayList<>();
        List<Node> add = new ArrayList<>();
        if (root==null) return root;
        Node ans = root;
        list.add(root);
        while(list.size()>0){
            add = new ArrayList<>();
            for (int i = 0;i<list.size();i++){
                Node tmp = list.get(i);
                if (tmp.left!=null){
                    add.add(tmp.left);
                } 
                if (tmp.right!=null){
                    add.add(tmp.right);
                } 
                if (i!=list.size()-1){
                    list.get(i).next = list.get(i+1);
                }
            }
            list = add;
        }
        return ans;
        
    }
}

