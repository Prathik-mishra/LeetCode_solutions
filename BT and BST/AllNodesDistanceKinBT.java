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
    private void getTrackOfParents(HashMap<TreeNode, TreeNode> track_parent, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                    track_parent.put(node.left,node);
                }
                if(node.right != null){
                    q.add(node.right);
                    track_parent.put(node.right,node);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> track_parent = new HashMap<>();
        getTrackOfParents(track_parent,root);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target,true);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k){  //now the que contains elements at a k distance from traget
                break;
            }
            distance++; //since the distance increases by one on next radial traversal
            for(int i=0; i<size; i++){
                TreeNode node = q.remove();
                //left Case:
                if(node.left != null && visited.get(node.left) == null){
                    q.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right != null && visited.get(node.right) == null){
                    q.add(node.right);
                    visited.put(node.right,true);
                }
                if(track_parent.get(node) != null && visited.get(track_parent.get(node)) == null){
                    q.add(track_parent.get(node));
                    visited.put(track_parent.get(node),true);
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.remove().val);
        }
        return result;
    }
}
