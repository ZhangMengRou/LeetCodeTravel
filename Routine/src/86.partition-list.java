
/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode l1 = head1;
        ListNode l2 = head2;

        while(head!=null){
            while (head!=null&&head.val<x){
                l1.next = head;
                while(l1.next!=null&&l1.next.val<x){
                 //   System.out.println("--"+l1.val);
                    l1 = l1.next;
                    
                }
                head = l1.next;
                
            }
            
            while (head!=null&&head.val>=x){
                l2.next = head;
                while(l2.next!=null&&l2.next.val>=x){
                    l2 = l2.next;
                }
                
                head = l2.next;
                l2.next=null;
                // System.out.println("--"+head.val);
            }
        }
        if (head1.next==null){
            return head2.next;
        }
        l1.next=head2.next;
        return head1.next;
    
    }
}

