#
# @lc app=leetcode.cn id=92 lang=python3
#
# [92] 反转链表 II
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        # reverse n
        self.tmp=None    
        def f(head,n):
            if n==1:
                self.tmp=head.next
                return head 
            last = f(head.next,n-1)
            head.next.next = head 
            head.next = self.tmp 
            return last 
        if left==1:
            return f(head,right)
        head.next = self.reverseBetween(head.next, left-1, right-1)        
        return head 
        
# @lc code=end

