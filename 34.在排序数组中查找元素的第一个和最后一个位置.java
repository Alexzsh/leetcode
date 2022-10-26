/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left =0,right=nums.length-1;
        int res=-1,min=0,max=0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                res=mid;
                break;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else 
                left=mid+1;
        }
        if(res==-1)
            return new int[]{-1,-1};
        min=res-1;
        max=res+1;
        while(min>=0 && nums[min]==target){
            min--;
        }
        while(max<nums.length && nums[max]==target){
            max++;
        }
        return new int[]{min+1,max-1};
    }
}
// @lc code=end

