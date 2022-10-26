#
# @lc app=leetcode.cn id=14 lang=python3
#
# [14] 最长公共前缀
#

# @lc code=start
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        tmp=strs[0]
        ans=0
        for index,c in enumerate(tmp):
            for s in strs:
                if index>=len(s) or s[index]!=c:
                    return tmp[:ans] 
            ans+=1
        return tmp[:ans]
# @lc code=end

