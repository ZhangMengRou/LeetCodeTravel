import java.util.ArrayList;


/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<>();
        int[] nList = new int[n+1];
        for (int i = 0;i<n;i++){
            nList[i] = i+1;
        }
        return generateTrees(nList,0,n-1);
        
    }
    public List<TreeNode> generateTrees(int[] n,int left,int right) {
        List<TreeNode> ans = new ArrayList<>();
        if (left > right){
        
            ans.add(null);
            return ans;
        }
        if (left == right){
            ans.add(new TreeNode(n[left]));
            return ans;
        }
        
        for (int i = left;i<=right;i++){
            List<TreeNode> leftNode = generateTrees(n, left, i-1);
            List<TreeNode> rightNode = generateTrees(n, i+1, right);
            
            
            for (int l = 0;l<leftNode.size();l++){
            for (int r = 0;r<rightNode.size();r++){
                TreeNode node = new TreeNode(n[i]);
                node.left = leftNode.get(l);
                node.right = rightNode.get(r);

                ans.add(node);
            }
            }
            
        }

        return ans;
        
    }

}

