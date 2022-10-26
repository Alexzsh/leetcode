import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,res=0;
        HashMap<Integer,Integer> maps = new HashMap<>();
        maps.put(0, 1);
        for(int i=0;i<nums.length;++i){
            sum+=nums[i];
            if(maps.containsKey(sum-k))
                res+=maps.get(sum-k);
            maps.put(sum, maps.getOrDefault(sum, 0)+1);
        }
        return res;
        
    }
}
// @lc code=end

