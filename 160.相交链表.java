/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2=headB;
        while(p1!=p2){
            p1 = p1==null ? headB:p1.next;
            p2 = p2==null ? headA:p2.next;
        }
        return p1;
    }
    public ListNode traverse(ListNode head){

        return head==null ?null: traverse(head.next);
    }
}
// @lc code=end

