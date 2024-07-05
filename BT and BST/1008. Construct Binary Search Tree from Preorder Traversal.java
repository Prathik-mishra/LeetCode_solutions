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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = {0};
        return constructBST(preorder,i,Integer.MAX_VALUE);
    }
    private TreeNode constructBST(int[] preorder, int[] i, int bound){
        if(i[0] == preorder.length || preorder[i[0]] > bound){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = constructBST(preorder,i,root.val);
        root.right = constructBST(preorder,i,bound);
        return root;
    }
}
