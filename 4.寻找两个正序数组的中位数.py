#
# @lc app=leetcode.cn id=4 lang=python3
#
# [4] 寻找两个正序数组的中位数
#

# @lc code=start
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n,m = len(nums1),len(nums2)
        
        if n>m:return self.findMedianSortedArrays(nums2, nums1)
        left,right=0,n 
        m1,m2=0,0
        while left<=right:
            i = left+(right-left)//2
            j = (n+m+1)//2-i 
            lmin= float('-inf') if i==0 else nums1[i-1]
            lmax = float('inf') if i==n else nums1[i]
            rmin = float('-inf') if j==0 else nums2[j-1]
            rmax = float('inf') if j==m else nums2[j]

            if lmin<=rmax:
                m1,m2 = max(lmin,rmin),min(lmax,rmax)
                left = i+1
            else:
                right= i-1
        return m1 if (m+n)%2==1 else (m1+m2)/2


# @lc code=end

