#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子数组和
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n=len(nums)
        dp=[0]*n 
        dp[0]=nums[0]
        for i in range(1,n):
            dp[i] = dp[i-1]+nums[i] if dp[i-1]>=0 else nums[i]
        return max(dp)
# @lc code=end

