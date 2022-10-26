#
# @lc app=leetcode.cn id=713 lang=python3
#
# [713] 乘积小于 K 的子数组
#

# @lc code=start
class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        # ans,tmp,j=0,1,0
        # for index,i in enumerate(nums):
        #     tmp*=i 
        #     while j<=index and tmp>=k:
        #         tmp//=nums[j]
        #         j+=1
        #     ans+=index-j+1
        # return ans
        if k==0:
            return 0
        ans=0
        presum=[0]*(len(nums)+1)
        for i in range(1,len(nums)+1):
            presum[i]=presum[i-1]+log(nums[i-1])
        lk=log(k)
        print(presum)
        for i in range(1,len(nums)+1):
            l = bisect_right(presum,presum[i]-lk+1e-10,0,i)
            r = bisect_left(presum,presum[i]-lk+1e-10,0,i)
            
            print(i,l,r,presum[i]-lk+1e-10)
            ans+=i-l
        return ans
        
# @lc code=end


