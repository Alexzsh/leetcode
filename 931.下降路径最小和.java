/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;++i){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;++i){
            for(int j=0;j<n;++j){
                int t_min;
                if(j==0)
                    t_min=Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j==n-1)
                    t_min=Math.min(dp[i-1][j-1],dp[i-1][j]);
                else
                    t_min=min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1]);
                dp[i][j]=matrix[i][j]+t_min;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            res = dp[n-1][i]<res?dp[n-1][i]:res;
        }
        return res;
    }
    public int min(int a,int b,int c){
        return Math.min(a,Math.min(b, c));
    }
}
// @lc code=end

