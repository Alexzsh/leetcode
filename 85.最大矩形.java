/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length,col=matrix[0].length;
        int[][] dp = new int[row][col];

        for(int i=0;i<row;++i)
            for(int j=0;j<col;++j){
                if(i==0||j==0){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=
            }
    }
}
// @lc code=end

