#
# @lc app=leetcode.cn id=862 lang=python3
#
# [862] 和至少为 K 的最短子数组
#

# @lc code=start
class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n=len(nums)
        presum=list(accumulate(nums,initial=0))
        ans=inf
        q = deque()
        for i,cur_s in enumerate(presum):
            while q and cur_s-presum[q[0]]>=k:
                ans = min(ans,i-q.popleft())
            while q and cur_s<=presum[q[-1]]:
                q.pop()
            q.append(i)
        return ans if ans<inf else -1
# @lc code=end

