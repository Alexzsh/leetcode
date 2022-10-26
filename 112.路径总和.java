import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        // if(root.left==null && root.right==null && root.val==targetSum) return true;
        // return hasPathSum(root, targetSum) || hasPathSum(root, targetSum-root.val);
        traverse(root,targetSum);
        return res;

    }

    public void traverse(TreeNode root,int targetSum){
        if(root==null) return;
        targetSum-=root.val;
        if(targetSum==0 && root.left==null && root.right==null){
            res = true;
        }
        traverse(root.left,targetSum);
        traverse(root.right,targetSum);
    }
}
// @lc code=end

