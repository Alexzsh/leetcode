/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int slow=0,fast=1;
        while(fast<nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;

        // int res=1,now=0,cur=1;
        // while(cur<nums.length){
        //     while(cur<nums.length &&nums[now]==nums[cur] )
        //         cur++;
        //     if(cur==nums.length)
        //         return res;
        //     nums[res++]=nums[cur];
        //     now=cur;
        //     cur=now+1;
        // }
        // return res;

    }
}
// @lc code=end

