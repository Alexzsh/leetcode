import java.security.KeyStore.Entry;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public int totalSteps(int[] nums) {
        Deque<Integer> stack = new ArrayDeque();
        int res=0;
        for(int i=0;i<nums.length;++i){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            res = Math.max(res, i-(stack.isEmpty()?0:stack.peek()));
            stack.push(i);
        }
        return res;
        // int left=0,right=0,res=0;
        // while(left<nums.length && right<nums.length){
        //     int temp=0;
        //     while(right<nums.length && nums[left]>nums[right++]){
        //         temp++;
        //     }
        //     left=right+1;
        //     res = Math.max(res, temp);
        // }
        // return res;

    }
    public String removeOuterParentheses(String s,String[] messages, String[] senders, String target) {

        int m = target.length();
        int[] chars = new int[26];
        List<Character> charss = new ArrayList();
        for(int i=0;i<m;++i)
            charss.add(target.charAt(i));
        int res=0;
        for(int i=0;i<s.length();++i){
            if(charss.contains(Character.valueOf(s.charAt(i))))
                charss.remove(Character.valueOf(s.charAt(i)));
            if(charss.size()==0){
                charss = new LinkedList(target);
                res++;
            }
        }
        return res;
        HashMap<String,Integer> map = new HashMap<>();
        int n = messages.length;
        for(int i=0;i<n;++i){
            map.put(senders[i],map.getOrDefault(senders[i],0)+1+ (int)messages[i].chars().filter(ch -> ch == ' ').count());
        }
        HashMap<String,Integer> map1 = map.entrySet().stream()
        .sorted((e1,e2)->e1.getValue()!=e2.getValue() ? e1.getValue().compareTo(e2.getValue()):e1.getKey().compareTo(e2.getKey()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(map1.toString());
        Arrays.asList();
        return map1.entrySet().iterator().next().getKey();
    }
}
// @lc code=end

