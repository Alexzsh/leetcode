import java.util.*;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int res=0,max=0;
        // List<String> pre = new LinkedList<String>();
        // for(int i=0;i<s.length();++i){
        //     String cur = String.valueOf(s.charAt(i));
        //     if(pre.contains(cur)){
        //         pre = pre.subList(pre.indexOf(cur)+1, pre.size());
        //     }
        //     pre.add(cur);
        //     res = pre.size();
        //     max = Math.max(res,max);
        // }
        // return max;

        // HashMap<Character,Integer> window = new HashMap<>();
        // int left=0,right=0,res=0;
        // while(right<s.length()){
        //     Character r = s.charAt(right++);
        //     window.put(r, window.getOrDefault(r, 0)+1);
        //     while(window.get(r)>1){
        //         Character l =s.charAt(left++);
        //         window.put(l, window.get(l)-1);
        //     }
        //     res=Math.max(res,right-left);
        // }
        // return res;

        int [] a = new int[10];
        for(int i=a.length-1;i>=0;--i){
            int r = new Random().nextInt(i);
            int t = a[i];
            a[i]=a[r];
            a[r]=t;
        }
        return 0;
    }
}
// @lc code=end

