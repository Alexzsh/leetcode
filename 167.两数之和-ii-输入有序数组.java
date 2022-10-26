import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // HashMap<Integer,Integer> maps = new HashMap<>();
        // for(int i=0;i<numbers.length;++i){
        //     if(maps.containsKey(target-numbers[i])){
        //         return new int[]{maps.get(target-numbers[i]),i+1};
        //     }
        //     else 
        //         maps.putIfAbsent(numbers[i], i+1);
        // }
        int left=0,right=numbers.length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target)
                return new int[]{left+1,right+1};
            else if(sum>target)
                right--;
            else 
                left++;
        }
        return new int[]{-1,-1};
    }
}
// @lc code=end

