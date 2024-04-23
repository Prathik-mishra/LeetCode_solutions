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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //creating a list to store the result of each level 
        List<List<Integer>> result = new ArrayList<>();
        
        //edge case(if root is null directly return the empty list)
        if(root == null) return result;
        
        //creating a queue to get the currentLevel node in the same Order
        Queue<TreeNode> queue = new LinkedList<>();
        
        //adding the first node in the queue
        queue.add(root);
        int levelOrder = 1;
        
        //running a loop till the queue gets empty
        while(queue.size() > 0){
            int currentLevelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            
            //running a loop till the current level size
            for(int i=0; i<currentLevelSize; i++){
                TreeNode currentNode = queue.remove();
                currentLevelNodes.add(currentNode.val);
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right); 
            }
            //just this is the changed thing from levelOrder traversal question 
            if(levelOrder%2 == 0){
                Collections.reverse(currentLevelNodes);
                result.add(currentLevelNodes);
            }else{
                result.add(currentLevelNodes);
            }
            levelOrder++;
        }
        return result;
    }
}