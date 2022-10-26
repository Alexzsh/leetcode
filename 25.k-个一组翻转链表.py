#
# @lc app=leetcode.cn id=25 lang=python3
#
# [25] K 个一组翻转链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def f(head,tail):
            pre,nxt=None,head 
            while head!=tail:
                nxt = head.next 
                head.next = pre 
                pre=head
                head=nxt 
            return pre
        if not head or not head.next:
            return head
        tail=head  
        for i in range(k):
            if not tail:
                return head 
            tail = tail.next 
        last = f(head,tail)
        head.next = self.reverseKGroup(tail, k)
        return last 

        
# @lc code=end

