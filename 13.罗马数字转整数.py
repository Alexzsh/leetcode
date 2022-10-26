#
# @lc app=leetcode.cn id=13 lang=python3
#
# [13] 罗马数字转整数
#

# @lc code=start
class Solution:
    def romanToInt(self, s: str) -> int:
        d={
            "I":             1
            ,"V":             5
            ,"X":             10
            ,"L":             50
            ,"C":             100
            ,"D":             500
            ,"M":             1000
        }
        pre=d[s[0]]
        ans=0
        for i in s[1:]:
            cur = d[i]
            if pre<cur:
                ans-=pre 
            else:
                ans+=pre
            pre=cur 
        ans+=pre 
        return ans  
            
# @lc code=end

