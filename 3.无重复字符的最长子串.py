#
# @lc app=leetcode.cn id=3 lang=python3
#
# [3] 无重复字符的最长子串
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        ans=0
        window={}
        left,right=0,0
        while right<n:
            if s[right] in window:
                left = max(left,window[s[right]])
            ans = max(ans, right-left+1)
            window[s[right]]=right+1
            right+=1
        return ans
# @lc code=end

