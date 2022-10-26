/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode dummy = new ListNode(-1,head);
    //     ListNode pre=dummy,end=dummy,endNext=null;
        
    //     while(end.next!=null){
    //         for(int i=0;i<k && end!=null;++i)
    //             end=end.next;
    //         if(end==null)
    //             break;
    //         ListNode start = pre.next;
    //         endNext = end.next;
    //         end.next = null;
    //         pre.next = reverseALL(start);
    //         start.next = endNext;
    //         pre=start;
    //         end=start;
    //     }
    //     return dummy.next;
    // }
    // public ListNode reverseALL(ListNode head){
    //     ListNode cur=null,pre=null;
    //     while(head!=null){
    //         cur=head.next;
    //         head.next = pre;
    //         pre=head;
    //         head = cur;
    //     }
    //     return pre;
    // }
    public ListNode reverseKGroup(ListNode head, int k) { 
        ListNode dummy = new ListNode(-1,head),end=dummy,pre=dummy,endNext=null;
        while(end.next!=null){
            for(int i=0;i<k && end!=null;++i){
                end=end.next;
            }
            if(end==null) break;
            ListNode start=pre.next;
            endNext = end.next;
            end.next=null;
            pre.next = reverseAll(start);
            start.next = endNext;
            pre=start;
            end=start;
        }
        return dummy.next;
    }
    public ListNode reverseAll(ListNode head){
        ListNode pre = null,next=null;
        while(head!=null){
            next = head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
// @lc code=end

