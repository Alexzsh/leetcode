import javax.swing.text.PlainDocument;

/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(f(piles,mid)>h){
                left=mid+1;
            }else 
                right=mid-1;
        }
        return left;
    }
    public int f(int[] piles,int x){
        int res=0;
        for(int i:piles){
            res += i/x;
            if(i%x>0)
                res++;
        }
        return res;
    }
}
// @lc code=end

