#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:

        def expand(s,left,right):
            while(left>=0 and right<len(s) and s[left]==s[right]):
                left-=1
                right+=1
            return left+1,right-1
        start,end=0,0
        for i in range(len(s)):
            l1,r1 = expand(s,i,i)
            l2,r2 = expand(s,i,i+1)
            if r1-l1>end-start:
                start=l1 
                end = r1 
            if r2-l2>end-start:
                start=l2
                end=r2 
        return s[start:end+1]
# @lc code=end

