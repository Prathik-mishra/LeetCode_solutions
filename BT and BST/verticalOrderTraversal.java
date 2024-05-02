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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Tuple> queue = new LinkedList<>();
        
        queue.add(new Tuple(root,0,0));
        
        while(!queue.isEmpty()){
            Tuple tup = queue.remove();
            TreeNode currNode = tup.node;
            int horizontal = tup.horizontal;
            int vertical = tup.vertical;
            
            if(!map.containsKey(vertical)){
                map.put(vertical,new TreeMap<>());
            }
            
            if(!map.get(vertical).containsKey(horizontal)){
                map.get(vertical).put(horizontal,new PriorityQueue<>());
            }
            
            map.get(vertical).get(horizontal).add(currNode.val);
            
            if(currNode.left != null){
                queue.add(new Tuple(currNode.left,vertical-1,horizontal+1));
            }
            
            if(currNode.right != null){
                queue.add(new Tuple(currNode.right,vertical+1,horizontal+1));
            }
        }
        
        for(TreeMap<Integer,PriorityQueue<Integer>> newMp : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : newMp.values()){
                while(!pq.isEmpty()){
                    list.get(list.size()-1).add(pq.remove());
                }
            }
        }
        return list;
    }
}

class Tuple{
    TreeNode node;
    int vertical;
    int horizontal;
    public Tuple(TreeNode _node,int _vertical,int _horizontal){
        this.node = _node;
        this.vertical = _vertical;
        this.horizontal = _horizontal;
    }
}
