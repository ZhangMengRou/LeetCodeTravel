/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        FindPath(root,sum,list);
        return ans;
    }
    
    public void FindPath(TreeNode root, int target,ArrayList<Integer> list) {
        if (root==null) return;
        list.add(root.val);
        if (root.val==target&&root.left==null&&
                root.right==null){
            ans.add(new ArrayList<>(list));
        }else {
            target = target-root.val;
            FindPath(root.left,target,new ArrayList<>(list));
            FindPath(root.right,target,new ArrayList<>(list));
        }
    }

}

