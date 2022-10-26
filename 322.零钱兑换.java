import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo, amount+1);
        memo[0]=0;
        for(int i=0;i<memo.length;++i){
            for(int coin:coins){
                if(i-coin<0)
                    continue;
                memo[i]=Math.min(memo[i-coin]+1, memo[i]);
            }
        }
        return memo[amount]==amount+1 ? -1:memo[amount];
        // return dp(coins, amount);
    }
    public int dp(int[] coins,int amount){
        if(amount==0) return 0;
        if(amount<0 ) return -1;
        if(memo[amount]!=-1) return memo[amount];
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int coin_counts =  dp(coins, amount-coin);
            if(coin_counts==-1) continue;
            res = Math.min(res, coin_counts+1);
        }
        memo[amount] = res==Integer.MAX_VALUE?-1:res;
        return memo[amount];
    }
}
// @lc code=end

