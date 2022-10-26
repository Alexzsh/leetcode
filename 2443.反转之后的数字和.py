#
# @lc app=leetcode.cn id=2443 lang=python3
#
# [2443] 反转之后的数字和
#

# @lc code=start
class Solution:
    def sumOfNumberAndReverse(self, num: int) -> bool:
        return any([(i+int(str(i)[::-1]))==num for i in range(num+1)])
# @lc code=end

