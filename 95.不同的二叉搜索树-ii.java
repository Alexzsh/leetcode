import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return gen(1,n);
    }
    public List<TreeNode> gen(int l,int r){
        List<TreeNode> res = new ArrayList<>();
        if(l>r){
            res.add(null);
            return res;
        }
        for(int i =l;i<=r;++i){
            for(TreeNode left:gen(l,i-1))
                for(TreeNode right:gen(i+1,r)){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            
        }
        return res;
    }
}
// @lc code=end

