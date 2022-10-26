import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2064 lang=java
 *
 * [2064] 分配给商店的最多商品的最小值
 */

// @lc code=start
class Solution {
    // 二分查找
    // 分配的商品数额越大，其能满足的商店数量越少，可以根据是否满足进行二分查找
    public int minimizedMaximum(int n, int[] quantities) {

        int left=0,right=Arrays.stream(quantities).max().getAsInt();
        while(left<right){
            int mid = left+(right-left)/2;
            if(check(n, mid, quantities))
                right=mid;
            else 
                left=mid+1;
        }
        return left;
    }
    public boolean check(int n,int m ,int[] quantities){
        int count=0;
        for(int q:quantities){
            count+= (q-1)/m+1;
        }
        return count<=n;
    }
}
// @lc code=end

