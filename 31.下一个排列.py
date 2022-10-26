#
# @lc app=leetcode.cn id=31 lang=python3
#
# [31] 下一个排列
#

# @lc code=start
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        first=-1
        for i in range(n-1,0,-1):
            if nums[i]>nums[i-1]:
                first=i-1
                break
        if first==-1:
            print(first,nums)
            nums.reverse()
        else:
            print(first)
            for i in range(n-1,first,-1):
                if nums[i]>nums[first]:
                    print(first,i)
                    nums[i],nums[first] = nums[first],nums[i]
                    break
            print(nums)
            nums[first+1:]=reversed(nums[first+1:])

# @lc code=end

