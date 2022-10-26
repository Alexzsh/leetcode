import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Deque<ListNode> qDeque = new LinkedList<>();
        // while(head!=null){
        //     qDeque.offerLast(head);
        //     head = head.next;
        // }
        // while(qDeque.size()>1){
        //     int a = qDeque.pollFirst().val;
        //     int b = qDeque.pollLast().val;
        //     if(a!=b)
        //         return false;    
        // }
        // return true;

        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        ListNode last = reverseALL(slow);
        boolean res = true;
        while(last!=null&&head!=null){
            if(head.val!=last.val)
                return false;
            head=head.next;
            last=last.next;
        }
        return true;

    }
    public ListNode reverseALL(ListNode head){
        ListNode cur=null,pre=null;
        while(head!=null){
            cur=head.next;
            head.next = pre;
            pre=head;
            head = cur;
        }
        return pre;
    }
}
// @lc code=end

