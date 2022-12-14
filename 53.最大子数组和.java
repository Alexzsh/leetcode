/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int dp_0 = nums[0];
        int res=dp_0;
        int dp_1 = 0;
        for(int i=1;i<nums.length;++i){
            dp_1 = Math.max(nums[i],nums[i]+dp_0);
            res = Math.max(res, dp_1);
            dp_0=dp_1;
        }
        return res;
    }
}
// @lc code=end

