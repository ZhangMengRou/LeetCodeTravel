

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {

    public Node copyRandomList(Node head) {
        Node tmp = head;
        Node next;
        while(tmp!=null){
            next =tmp.next;
            Node n=new Node();
            n.val = tmp.val;
            tmp.next = n;
            n.next = next;
            tmp = next;
        }
        tmp = head;
        while(tmp!=null){
            Node n=tmp.next;
            n.random = tmp.random==null?null:tmp.random.next;
            tmp = tmp.next.next;
        }
        tmp = head;
        Node ans = new Node();
        ans.val = -1;
        Node it = ans;
        Node copy;
        while(tmp!=null){
            copy = tmp.next;
            it.next = copy;
            tmp.next = copy.next;
            
            tmp = tmp.next;

            it = it.next;
        }
        return ans.next;
    }
}

