

/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {


        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while(left<right){
            int mid =left+(right-left)/2;
            if(ff(nums,mid)>m)
                left=mid+1;
            else right=mid;
        }
        return left;
    }
    public int ff(int[] nums,int x){
        int res=1,i=0;
        // int cap=x;
        // for(int j=0;j<nums.length;++j){
        //     if(cap>=nums[j]){
        //         cap-=nums[j];
        //     }
        //     else{
        //         res++;
        //         cap=x-nums[j];
        //     }
            
        // }
        while(i<nums.length){
            int cap = x;
            while(i<nums.length)
             if(cap>=nums[i]){
                cap-=nums[i++];
            }else{
                res++;
                break;
            }

            // res++;
        }
        return res;
    }
    public int f(int[] nums, int x) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt ;
    }

}
// @lc code=end

