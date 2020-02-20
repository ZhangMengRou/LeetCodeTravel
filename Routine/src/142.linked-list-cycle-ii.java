import java.util.HashSet;

/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
t = X + nY + K
2t = X + mY + K
推出
X+K  =  (m-2n)Y 
头指针从头走x步到环起点
快指针从环起点走k+x步为y的倍数也回到环起点
所以他们必定在环起点相遇
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next ==null){
            return null;
        }
        ListNode q = head.next.next;
        ListNode s = head.next;
        while(q!=null){
            if (s==q){
                break;
            }
            q = q.next==null?null:q.next.next;
            s = s.next;
        }
     //   System.out.println(q);
        if (q==null){
            return null;
        }
        
        while(head!=q){
            
            head = head.next;
            q = q.next;
           

        }
        return head;
    }
}
// @lc code=end

