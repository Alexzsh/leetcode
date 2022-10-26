import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;++i){
                nums1[i]=nums2[i];
            }
            return;
        }
        if(n==0) return;
        int left = 0,target=m,right=0;
        while(left<target && right<n){
            if(nums1[left]>nums2[right]){
                for(int i=target-1;i>=left;--i){
                    nums1[i+1]=nums1[i];
                }
                nums1[left++]=nums2[right++];
                target++;
                System.out.println(Arrays.toString(nums1));
            }
            else{
                left++;
            }
        }
        if(left==target){
            while(right<n){
                nums1[target++]=nums2[right++];
            }
        }

    }
    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
// @lc code=end

