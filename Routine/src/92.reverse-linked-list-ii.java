
/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode ans = a;
        
        for (int i = 1;i<m;i++){
           
            a = a.next;
        }
        ListNode pre = a;
        ListNode flag = a.next;
        ListNode then = a.next.next;
        for (int i = 0;i<n-m;i++){
           //  System.out.println(then.val);
            flag.next = then == null?null:then.next;
            then.next = pre.next;
            pre.next = then;
            then = flag.next;
        }
       
        return ans.next;
        
    }
}

