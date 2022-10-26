/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;
        for(int w:weights){
            left = Math.max(left, w);
            right += w;
        }
        while(left<right){
            int mid = left+(right-left)/2;
            if(f(weights,mid)>days){
                left=mid+1;
            }
            else
                right=mid;
        }
        return left;
    }
    public int f(int[] weights,int x){
        int res=0, i=0;
        while(i<weights.length){
            int weight = 0;
            while(i<weights.length&&weights[i]+weight<=x){
                weight+=weights[i++];
            }
            res+=1;
        }
        return res;
    }
    int ff(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
// @lc code=end

