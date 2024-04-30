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
        if(root == null){
            return null;
        }
        
        if(root == p || root == q){
            return root;
        }
        
        //Recursive Case:
        TreeNode leftChild = lowestCommonAncestor(root.left,p,q);
        TreeNode rightChild = lowestCommonAncestor(root.right,p,q);
        
        if(leftChild == null && rightChild == null){
            return null;
        }
        else if(leftChild != null && rightChild != null){
            return root;
        }
        else{
            if(leftChild != null) return leftChild;
            else return rightChild;
        }
    }
}
