/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0,minP=prices[0];
        for(int i=1;i<prices.length;++i){
            minP = Math.min(minP,prices[i]);
            res = Math.max(res,prices[i]-minP);
        }
        return res;
    }
}
// @lc code=end

