import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        
        LinkedList<Integer> numsList = new LinkedList<>();
        permuteAll(nums, numsList);
        return res;

    }
    public void permuteAll(int[] numsList,LinkedList<Integer> trackList){
        if(trackList.size()==numsList.length){
            res.add(new LinkedList<Integer>(trackList));
            return;
        }
        for(int i=0;i<numsList.length;++i){
            if(trackList.contains(numsList[i]))
                continue;
            trackList.add(numsList[i]);
            permuteAll(numsList, trackList);
            trackList.removeLast();
        }
    }
}
// @lc code=end

