#
# @lc app=leetcode.cn id=2444 lang=python3
#
# [2444] 统计定界子数组的数目
#

# @lc code=start
class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        ans=0
        min_i=max_i=i0=-1
        for i,n in enumerate(nums):
            if n==minK: min_i=i 
            if n==maxK:max_i=i 
            if not minK<=n<=maxK: i0=i 
            ans += max(min(min_i,max_i)-i0,0)
        return ans 
# @lc code=end

