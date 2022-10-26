import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
// class Solution {
//     public int search(int[] nums, int target) {
//         int left=0,right=nums.length-1;
//         while(left<=right){
//             int mid = left+(right-left)>>1;
//             if(nums[mid]==target)
//                 return mid;
//             else if(nums[mid]>target){
//                 right=mid-1;
//             }
//             else 
//                 left=mid+1;
//         }
//         return -1;
//     }
// }
class CQueue {
    private LinkedList<Integer> in,out;
    public CQueue() {
        this.in = new LinkedList();
        this.out = new LinkedList();
    }
    
    public void appendTail(int value) {
        in.addLast(value);
    }
    
    public int deleteHead() {
        if(in.isEmpty())
            return -1;
        while(!in.isEmpty()){
            out.addLast(in.pollLast());
        }
        int top=out.pollLast();
        while(!out.isEmpty())
            in.addLast(out.pollLast());
        return top;
    }
}
// @lc code=end

