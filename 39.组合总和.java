import java.util.LinkedList;
import java.util.List;

import javax.print.CancelablePrintJob;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0,target, new LinkedList<>());
        return res;
    }
    public void dfs(int[] candidates,int start,int target,LinkedList<Integer> temp){
        if(target==0) res.add(new LinkedList<>(temp));
        if(target<0) return;
        
        for(int i = start;i<candidates.length;++i){
            temp.offerLast(candidates[i]);
            dfs(candidates,start,target-candidates[i],temp);
            temp.pollLast();
        }
    
    }
}
// @lc code=end

