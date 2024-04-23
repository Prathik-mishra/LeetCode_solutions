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
    public int diameterOfBinaryTree(TreeNode root) {
        //since java dont pass variable as a reference and creates a new copy on every recurssion call it will not change the final variablee val so we pass a array insted of a variable or we could have used a global variable also its just a smart way to do this.
        int[] diameter = new int[1];
        findDia(root,diameter);
        return diameter[0];
    }
    public int findDia(TreeNode root,int[] diameter){
        if(root == null) return 0;
        
        int leftH = findDia(root.left,diameter);
        int rightH = findDia(root.right,diameter);
        
        diameter[0] = Math.max(diameter[0],leftH+rightH);
        return 1 + Math.max(leftH,rightH);
    }
}