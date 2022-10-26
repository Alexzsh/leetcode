#
# @lc app=leetcode.cn id=630 lang=python3
#
# [630] 课程表 III
#

# @lc code=start
class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key=lambda x:x[1])

        heap=[]
        total=0
        for d,t in courses:
            if total+d<=t:
                total+=d
                heappush(heap,-d)
            else:
                if heap and -heap[0]>d:
                    total+=heappop(heap)+d
                    heappush(heap,-d)
        return len(heap)
# @lc code=end

