#
# @lc app=leetcode.cn id=215 lang=python3
#
# [215] 数组中的第K个最大元素
#

# @lc code=start
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        

        def quickSort(nums,l,r,k):
            mid = randPartition(nums,l, r)
            if mid==k-1:
                return nums[mid] 
            elif mid<k-1:
                return quickSort(nums, mid+1, r, k)
            else:
                return quickSort(nums, l, mid-1, k)
            
        def randPartition(nums,l,r):
            rn = random.randint(l,r)
            nums[l],nums[rn]=nums[rn],nums[l]
            return partition(nums,l,r)
        def partition(nums,l,r):
            pviot=nums[l]
            low,high = l,r 
            while low<high:
                while low<high and nums[high]>=pviot:
                    high-=1
                nums[low]=nums[high]
                while low<high and nums[low]<=pviot:
                    low+=1
                nums[high]=nums[low]
            nums[low]=pviot
            return low
             
        

        return quickSort(nums, 0, len(nums)-1, len(nums)-k+1)
# @lc code=end

