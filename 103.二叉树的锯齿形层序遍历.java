import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag=true;;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0;i<size;++i){
                TreeNode top = flag?queue.pollFirst():queue.pollLast();
                temp.add(top.val);
                if(flag){
                    if(top.left!=null)
                        queue.addLast(top.left);
                    if(top.right!=null)
                        queue.addLast(top.right);
                }
                else{
                    if(top.right!=null)
                        queue.addFirst(top.right);
                    if(top.left!=null)
                        queue.addFirst(top.left);
                    
                }
            }
            res.add(temp);
            flag=!flag;
        }
        return res;
    }
}
// @lc code=end

