# # from  heapq import *
# # material=[10,2,6,1]
# # def f(material):
# #     heap=[-i for i in material]
# #     heapify(heap)
# #     while heap:
# #         l=heappop(heap)
# #         if not heap:
# #             return -l
# #         r=heappop(heap)
# #         heappush(heap,l-r)
# #     return 0
# # print(f(material))
# # _nums=[1,2,3]
# # n=len(_nums)
# # is_vis=[0]*n 
# # res=[]
# # def f(nums):
# #     if len(nums)==n:
# #         res.append(nums[:])
# #     for index,i in enumerate(_nums):
# #         if is_vis[index]==1:
# #             continue
# #         nums.append(i)
# #         is_vis[index]=1
# #         f(nums)
# #         nums.pop()
# #         is_vis[index]=0
# # f([])
# # print(res)

    

# def f():
#     arr=[2,3,9]
#     arr.sort()
#     n='2311'
#     nums=[int(i) for i in n]
    
#     def dfs(is_limit,index):
#         if index ==len(nums):
#             return 0 
#         if is_limit:
#             for i in range(len(arr)-1,-1,-1):
#                 if ( index<len(nums)-1 and arr[i]<=nums[index]) or (index==len(nums)-1 and arr[i]<nums[index]):
#                     tmp = dfs(arr[i]==nums[index],index+1)
#                     if tmp==-1:
#                         continue
#                     return arr[i]*pow(10,len(nums)-index-1)+tmp
#             if index==0:
#                 return dfs(False,index+1)
#             return -1 
#         else:
#             return arr[-1]*pow(10,len(nums)-index-1)+dfs(False,index+1)
    
#     return dfs(True,0)
# print(f())  
    


# data=[[1,4],[4,5]]

# def f(nums):
#     nums.sort(key=lambda x:x[0])
    
#     ans=[]
#     i=0
#     while i<len(nums):
#         cur_l,cur_r=nums[i][0],nums[i][1]    
#         while i+1<len(nums) and  cur_r>=nums[i+1][0]:
#             cur_r = max(cur_r,nums[i+1][1])
#             i+=1
#         ans.append([cur_l,cur_r])
#         i+=1
#     return ans 
# print(f(data))


# ListNode
# 获取当前节点的最大路径值
# ans=-2**40
# def f(root:ListNode)->ListNode:
#     if not root: return 0 
#     left = f(root.left)
#     right = f(root.right)
#     nonlocal ans 
#     if left+right<=0:
#         return root.val
#     ans = max(ans,root.val+max(left,0)+max(right,0))
#     return root.val+max(left,right,0) 

# nums uint [3,5,1,2,7]
# def f(nums,k):

def f(nums):
    n=len(nums)
    l,r=0,n-1
    mid=l+(r-l)//2
    while l<r:
        if mid+1<n and mid-1>=0 and nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
            return mid 
        if mid<=l+1 and nums[mid]<nums[mid+1] or nums[mid]>nums[mid-1] and nums[mid]<nums[mid+1]:
            l=mid+1
        else:
            r=mid-1
    return -1

# print(any([[1,2,3],[4,5,6]]))
s="12345678901"
print(s[1:len(s)])




