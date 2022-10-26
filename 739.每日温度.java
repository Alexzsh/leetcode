import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[temperatures.length];
        for(int i=1;i<temperatures.length;++i){
            while(!stack.isEmpty() && temperatures[i]> temperatures[stack.peek()]){
                Integer top = stack.pop();
                res[top]=i-top;
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()]=0;
        }
        return res;
        
    }
}
// @lc code=end

