#
# @lc app=leetcode.cn id=2442 lang=python3
#
# [2442] 反转之后不同整数的数目
#

# @lc code=start
class Solution:
    def countDistinctIntegers(self, nums: List[int]) -> int:
        return len(set(nums+[int(str(i)[::-1]) for i in nums]))
# @lc code=end

