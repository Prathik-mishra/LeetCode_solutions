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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Base Case:
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        
        //Recursive case:
        if(p.val != q.val){
            return false;
        }
        
        boolean isLeftSame = isSameTree(p.left,q.left);
        boolean isRightSame = isSameTree(p.right,q.right);
        
        if(isLeftSame && isRightSame){
            return true;
        }else{
            return false;
        }
    }
}