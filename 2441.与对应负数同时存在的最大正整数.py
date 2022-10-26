#
# @lc app=leetcode.cn id=2441 lang=python3
#
# [2441] 与对应负数同时存在的最大正整数
#

# @lc code=start
class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        ans=-1
        sett=set()
        for i in nums:
            if -i in sett:
                ans = max(ans,abs(i))
            sett.add(i)
        return ans 
# @lc code=end

