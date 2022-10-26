#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
class Solution:
    def myAtoi(self, s: str) -> int:
        index=0
        while index<len(s) and s[index]==' ':
            index+=1
        if index>=len(s):
            return 0
        math_str='0123456789'
        flag = -1 if s[index]=='-' else 1
        if s[index]=='-' or s[index]=='+':
            index+=1
        res=0
        
        while index<len(s) and s[index] in math_str:
            res=res*10+(ord(s[index])-ord('0'))
            index+=1
        res = res*flag
        res = 2**31-1 if res>2**31-1 else res 
        res = -2**31 if res<-2**31 else res 
        return res
# @lc code=end

