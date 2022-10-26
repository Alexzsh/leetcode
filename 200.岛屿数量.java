/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length,n=grid[0].length,res=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]=='1'){
                    
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid,int i,int j){
        int m = grid.length,n=grid[0].length;
        if(i<0 || j>=n ||i>=m || j<0 || grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
    }
}
// @lc code=end

