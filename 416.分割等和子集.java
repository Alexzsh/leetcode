/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
    
        int sum = 0;
        for(int i:nums)
            sum+=i;
        if(sum%2!=0) return false;
        sum/=2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;++i)
            dp[i][0]=true;
        
        for(int i=1;i<=n;++i){
            for(int w=1;w<=sum;++w){
                if(nums[i-1]>w)
                    dp[i][w]=dp[i-1][w];
                else 
                    dp[i][w]=dp[i-1][w]|| dp[i-1][w-nums[i-1]];
            }
        }
        return dp[n][sum];
    }
}
// @lc code=end

