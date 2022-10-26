import java.util.*;
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length<=2) return res;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;++i){
            if(i>0 && nums[i]==nums[i-1] ) continue;
            if(nums[i]>0) break;
            int left = i+1,right=nums.length-1;
            while(left<right){
                
                if( nums[left]+nums[right]+nums[i]>0) right--;
                else if(nums[left]+nums[right]+nums[i]<0) left++;
                else {
                    List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
                    res.add(temp);
                    while(left<right && nums[left+1]==nums[left]) left++;
                    while(left<right && nums[right-1]==nums[right]) right--;
                    
                    left++;
                    right--;
                }
                
            }
        }
        return res;
    }
}
// @lc code=end

