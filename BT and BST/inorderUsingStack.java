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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        //itterative approach:
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(root != null){
                st.add(root);
                root = root.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                root = st.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
