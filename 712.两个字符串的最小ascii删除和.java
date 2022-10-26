/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
class Solution {

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(),m=s2.length();
        int[][] dp =new int[n+1][m+1];
        for(int i=1;i<=n;++i)
            for(int j=1;j<=m;++j)
                dp[i][j] = s1.charAt(i-1)==s2.charAt(j-1) ? dp[i-1][j-1]+s1.charAt(i-1) : Math.max(dp[i-1][j], dp[i][j-1]);
        int sum=0;
        for(int i=0;i<n;++i)
            sum+=s1.charAt(i);
        for(int i=0;i<m;++i)
            sum+=s2.charAt(i);
        return sum-2*dp[n][m];
    }
}
// @lc code=end

