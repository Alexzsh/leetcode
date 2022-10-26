/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        int index = partition(nums,left,right);
        quickSort(nums, left, index-1);
        quickSort(nums, index+1, right);
            
    }
    public int partition(int[] nums,int left,int right){
        int pviot = nums[left],last = left;
        for(int i =left+1;i<=right;++i){
            if(nums[i]<pviot){
                swap(nums,i,++last);
            }
        }
        swap(nums,left,last);
        return last;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
// @lc code=end

