import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        for(int i=0;i<heights.length;++i){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                right[stack.pop()]=i;
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        int res =0;
        for(int i=0;i<heights.length;++i){
            res=Math.max(res, heights[i]*(right[i]-left[i]-1));
        }
        return res;

        // Stack<Integer> right = new Stack<>();
        // int[] rightMax = new int[heights.length];
        // for(int i=0;i<heights.length;++i){
        //     while(!right.isEmpty() && heights[i]<=heights[right.peek()]){
        //         right.pop();
        //     }
        //     rightMax[i]= right.isEmpty()?-1:right.peek();
        //     right.push(i);
        // }

        // Stack<Integer> left = new Stack<>();
        // int[] leftMax = new int[heights.length];
        // for(int i=heights.length-1;i>=0;--i){
        //     while(!left.isEmpty() && heights[i]<=heights[left.peek()]){
        //         left.pop();
        //     }
        //     leftMax[i]= left.isEmpty()?heights.length: left.peek();
        //     left.push(i);
        // }

        // int res = 0;
        // for(int i=0;i<heights.length;++i){
        //     res = Math.max(res, heights[i]*Math.abs(leftMax[i]-rightMax[i]-1));
        // }
        // return res;
    }
}
// @lc code=end

