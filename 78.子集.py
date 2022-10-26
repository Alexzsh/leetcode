#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        def f(_nums,index):
            res.append(_nums[:])
            for i in range(index,len(nums)):
                f(_nums+[nums[i]],i+1)
        f([],0)
        return res



# @lc code=end

