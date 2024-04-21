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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        //itterative approach:
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            st2.add(node);
            if(node.left != null){
                st1.add(node.left);
            }
            if(node.right != null){
                st1.add(node.right);
            }
        }
        
        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }
}
