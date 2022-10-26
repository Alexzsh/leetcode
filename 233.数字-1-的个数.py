#
# @lc app=leetcode.cn id=233 lang=python3
#
# [233] 数字 1 的个数
#

# @lc code=start
class Solution:
    def countDigitOne(self, n: int) -> int:
        s=str(n)
        @cache
        def f(i,cnt,is_limit):
            if i==len(s):
                return cnt 
            res=0 
            up = int(s[i]) if is_limit else 9
            for d in range(0,up+1):
                res+=f(i+1,cnt+(d==1),is_limit and d==up)
            return res 
        return f(0,0,True)

# @lc code=end

