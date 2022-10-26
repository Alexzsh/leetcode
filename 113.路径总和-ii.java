import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> temp = new LinkedList<>();
    
    public void traverse(TreeNode root,int targetSum){
        if(root==null) return;
        targetSum-=root.val;
        temp.offerLast(root.val);
        if(targetSum==0 && root.left==null && root.right==null){
            res.add(new LinkedList<>(temp));
        }
        traverse(root.left,targetSum);
        traverse(root.right,targetSum);
        temp.pollLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root==null) return res;
        traverse(root, targetSum);
        return res;
    }
}
// @lc code=end

