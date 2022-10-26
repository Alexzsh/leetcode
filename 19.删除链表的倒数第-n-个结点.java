/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;

    }
    public ListNode findNthFromEnd(ListNode head,int n){
        ListNode cur=head,target=head;
        for(int i=0;i<n;++i){
            if(cur==null)
                return null;
            cur=cur.next;
        }
        if(cur==null)
            return head.next;
        while(cur!=null){
            cur=cur.next;
            target=target.next;
        }
        return target;
    }
}
// @lc code=end

