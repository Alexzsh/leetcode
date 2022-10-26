import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();++i){
            char cur = s.charAt(i);
            if(stack.isEmpty() || stack.peek()!=map.get(cur)){
                stack.push(cur);
            }
            else if(stack.peek()==map.get(cur)){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

