#
# @lc app=leetcode.cn id=207 lang=python3
#
# [207] 课程表
#

# @lc code=start
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = [[] for i in range(numCourses)]
        in_degree=[0 for i in range(numCourses)]
        for i,j in prerequisites:
            graph[j].append(i)
            in_degree[i]+=1
        
        queue = [i for i in range(numCourses) if in_degree[i]==0]
        res=[]
        while queue:
            top = queue.pop()
            res.append(top)
            for i in graph[top]:
                in_degree[i]-=1
                if in_degree[i]==0:
                    queue.append(i)
        return len(res)==numCourses
# @lc code=end

