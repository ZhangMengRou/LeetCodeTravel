

/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */
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

    public void flatten(TreeNode root) {
        root =  flattenL(root);
        
    }
    public TreeNode flattenL(TreeNode root) {
     
        if (root == null) return root;
        if (root.left == null&& root.right==null){
        return root;
        }
        TreeNode right = null;
        TreeNode left = null;
        if (root.right != null){

            right = flattenL(root.right);
            
        }
        if (root.left != null){
            left = flattenL(root.left);
            root.right = left;
        }else{
        root.right = left;
    }

        TreeNode hNode =  root;
        TreeNode tmp = hNode;
        while(tmp.right!=null){
            tmp.left = null;
            tmp = tmp.right;
        }
        if (right!=null)
        {
            
            tmp.right = right;
        }
        return hNode;

    }
}

