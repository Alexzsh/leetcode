/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    int res = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, 0);
        return res;
    }
    public void dfs(int[][] grid,int i,int j,int sum){
        int n=grid.length,m=grid[0].length;
        if(i<n-1)
            dfs(grid,i+1,j,sum+grid[i][j]);
        if(j<m-1)
            dfs(grid,i,j+1,sum+grid[i][j]);        
        if(i==n && j==m){
            res = Math.min(res, sum+grid[i][j]);
        }
    }
}
// @lc code=end

