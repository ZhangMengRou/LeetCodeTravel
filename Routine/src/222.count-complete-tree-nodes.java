import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q =  new LinkedList<TreeNode>();
        if (root==null){
            return 0;
        }
        q.offer(root);
        int count  = 0;
        while(q.size()>0){
            count++;
            TreeNode node = q.poll();
            if (node.left!=null) q.offer(node.left);
            if (node.right!=null) q.offer(node.right);
            
        }
        return count;
        
    }
}
// @lc code=end

