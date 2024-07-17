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
    private List<TreeNode> forest;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int node : to_delete){
            set.add(node);
        }
        root = helpDelNodes(root,set);
        
        if(root != null){
            forest.add(root);
        }
        
        return forest;
        
    }
    
    private TreeNode helpDelNodes(TreeNode root, Set<Integer> set){
        if(root == null){
            return null;
        }
        
        root.left = helpDelNodes(root.left,set);
        root.right = helpDelNodes(root.right,set);
        
        if(set.contains(root.val)){
            if(root.left != null){
                forest.add(root.left);
            }
            if(root.right != null){
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }
}
