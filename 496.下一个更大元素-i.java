import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();

        // int[] res = new int[nums2.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;++i){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        // for(int i=0;i<res.length;++i)
        //     map.put(i, res[i]);
        int[] ress = new int[nums1.length];
        for(int i=0;i<nums1.length;++i){
            ress[i]= map.getOrDefault(nums1[i], -1);
        }
        return ress;
        
    }
}
// @lc code=end

