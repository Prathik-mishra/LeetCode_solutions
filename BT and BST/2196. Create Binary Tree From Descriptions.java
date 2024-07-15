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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,Pair> hmap = new HashMap<>();
        
        for(int[] arr : descriptions){
            int parent = arr[0];
            int child = arr[1];
            boolean isLeft = arr[2] == 1 ? true : false;
            
            if(hmap.containsKey(parent) == false){
                TreeNode node = new TreeNode(parent);
                hmap.put(parent, new Pair(node,false));
                makeConnection(hmap,node,isLeft,child);
            }else{
                TreeNode node = hmap.get(parent).node;
                makeConnection(hmap,node,isLeft,child);
            }
        }
        
        for(int key : hmap.keySet()){
            Pair p = hmap.get(key);
            if(p.isChild == false){
                return p.node;
            }
        }
        
        return null;
    }
    private void makeConnection(HashMap<Integer,Pair> hmap,TreeNode node, boolean isLeft, int child){
        if(isLeft){
            if(hmap.containsKey(child) == true){
                node.left = hmap.get(child).node;
                // hmap.put(child,new Pair(node.left,true));
                hmap.get(child).isChild = true;
            }else{
                node.left = new TreeNode(child);
                hmap.put(child,new Pair(node.left,true));
            }     
        }else{
            if(hmap.containsKey(child) == true){
                node.right = hmap.get(child).node;
                // hmap.put(child,new Pair(node.right,true));
                hmap.get(child).isChild = true;
            }else{
                node.right = new TreeNode(child);
                hmap.put(child,new Pair(node.right,true));
            }
        }
    }
}

class Pair{
    TreeNode node;
    boolean isChild;
    public Pair(TreeNode node,boolean isChild){
        this.node = node;
        this.isChild = isChild;
    }
}
