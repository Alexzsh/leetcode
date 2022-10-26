import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return findByMinHeap(nums,k);
        return findByQuickSort(nums, 0, nums.length-1, nums.length-k);
    }


    public int findByQuickSort(int[] nums,int left,int right,int k){
        return quickSort(nums, left, right, k);
    }
    public int quickSort(int[] nums,int left,int right,int k){
        while(true){
            int index = partition(nums,left,right);
            if(index==k)
                return nums[index];
            else if(index<k)
                left=index+1;
            else 
                right = index-1;
        }
           
    }
    public int partition(int[] nums,int left ,int right){
        int pviot = nums[left];
        int greater = left;
        for(int i = left+1;i<=right;++i){
            if(nums[i]<pviot){
                swap(nums, i, ++greater);
            }
        }
        swap(nums, left, greater);
        return greater;

    }
    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public int  findByMinHeap(int[] nums,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;++i){
            if(i<k){
                minHeap.offer(nums[i]);
            }
            else{
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
}
// @lc code=end

