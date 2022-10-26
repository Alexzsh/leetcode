import java.util.*;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> maps = new HashMap();
        for(int i:nums)
            maps.put(i, maps.getOrDefault(i, 0)+1);
        List<Map.Entry<Integer,Integer>> count = new LinkedList<>();
        for(Map.Entry<Integer,Integer> e:maps.entrySet()){
            count.add(e);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b ){
                return a.getValue()-b.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> e:count){
            if(minHeap.size()<k)
                minHeap.offer(e);
            else{
                if(minHeap.peek().getValue()<e.getValue()){
                    minHeap.poll();
                    minHeap.offer(e);
                }
            }
        }
        int[] res= new int[k];
        while(k-->0){
            res[k]= minHeap.poll().getKey();
        }
        return res;
    }
}
// @lc code=end

