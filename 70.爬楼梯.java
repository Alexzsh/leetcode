/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        return dp(n);
    }
    public int dp(int n){
        if(n<=2) return n;
        if(memo[n]>0) return memo[n];
        memo[n]=dp(n-1)+dp(n-2);
        return memo[n];
    }
}
// @lc code=end

