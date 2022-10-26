import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return res;
    }
    TreeNode res = null;
    public List<TreeNode> traverse(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> list = new LinkedList<>();
        if(root==null || res!=null) return list;

        List<TreeNode> left= traverse(root.left,p,q);
        List<TreeNode> right= traverse(root.right,p,q);
        List<TreeNode> cur = new LinkedList<>();
        cur.add(root);
        cur.addAll(right);
        cur.addAll(left);
        if(res==null && cur.contains(p) && cur.contains(q)){
            res=root;
        }
        return cur;
    }
}
// @lc code=end

