/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        return minDistanceCal(word1, l1, word2, l2);
    }
    public int minDistanceCal(String s1,int l1,String s2,int l2){
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;++i)
            dp[i][0]=i;
        for(int j=0;j<=l2;++j)
            dp[0][j]=j;
        for(int i=1;i<=l1;++i)
            for(int j=1;j<=l2;++j){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
            }

        return dp[l1][l2];
    }
    public int min(int a,int b ,int c){
        return Math.min(c, Math.min(a, b));
    }
}
// @lc code=end

