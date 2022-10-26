/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // return count(1, n);
        int[][] memo = new int[n+1][n+1];
        return countDp(1, n, memo);
    }
    public int count(int l,int r){
        if(l>=r) return 1;

        int res=0;
        for(int i=l;i<=r;++i){
            int left = count(l, i-1);
            int right = count(i+1, r);
            res+=(left*right);            
        }
        return res;
    }
    
    public int countDp(int l,int r,int[][] memo){
        if(l>=r) return 1;
        if(memo[l][r]>0) return memo[l][r];

        int res = 0;
        for(int i=l;i<=r;++i){
            int left = countDp(l, i-1, memo);
            int right = countDp(i+1, r, memo);
            res +=(left*right);
        }
        memo[l][r]=res;
        return res;

    }
}
// @lc code=end

