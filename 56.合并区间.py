#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#

# @lc code=start
class Solution:
    # 排序+双指针
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals)==1:
            return intervals
        intervals.sort(key=lambda a:a[0])
        first=0
        res=[]
        while first<len(intervals):
            cur_min=intervals[first][0]
            cur_max=intervals[first][1]
            second=first+1
            while second<len(intervals) and intervals[second][0]<=cur_max:
                cur_max=max(cur_max,intervals[second][1])
                second+=1
            res.append([cur_min,cur_max])
            first=second
        return res

# @lc code=end

