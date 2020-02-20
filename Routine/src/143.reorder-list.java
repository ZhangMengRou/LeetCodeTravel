

/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //  public class ListNode {
    //          int val;
    //          ListNode next;
    //          ListNode(int x) { val = x; }
    //      }
    public void reorderList(ListNode head) {
        
        if (head==null||head.next==null){
            return;
        }

        // find
        ListNode s = head;
        ListNode q = head;
        ListNode mid = s;
        while(q.next!=null&&q.next.next!=null){
            s = s.next;
            q = q.next.next;
        }
        mid = s;
   
        // re
        ListNode re = s.next;
        while(re.next!=null){
            ListNode tail = re.next;
            re.next = tail.next;
            tail.next = mid.next;
            mid.next = tail;
            
        }
     
        // merge
        ListNode p1 = head;
        ListNode p2 = mid.next;
        while(p1!=mid){
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
       
        
        
    }
}
// @lc code=end

