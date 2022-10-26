#
# @lc app=leetcode.cn id=977 lang=python3
#
# [977] 有序数组的平方
#

# @lc code=start
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        first=-1
        res=[]
        
        for index,i in enumerate(nums) :
            if i>0 and first==-1:
                first=index 
        if first==0:
            return [j**2 for j in nums]
        elif first==-1:
            return [j**2 for j in nums[::-1]]
        minus=first-1
        while minus>=0 and first<len(nums):
            if nums[minus]*-1<nums[first]:
                res.append(nums[minus]**2)
                minus-=1
            else:
                res.append(nums[first]**2)
                first+=1
            print(minus,first,res)
        if minus<0:
            res.extend([j**2 for j in nums[first:]])
        else:
            res.extend([j**2 for j in nums[:minus+1:-1]])
        print(minus,nums[:minus+1:-1],nums[:minus+1:],nums[0:1:-1])
        print(res)
        return res
# @lc code=end

