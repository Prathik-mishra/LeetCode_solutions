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
    private static String finalPath;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        finalPath = "";
        
        HashMap<Integer,TreeNode> getParent = new HashMap<>();
        getParent.put(root.val,null);
        parentChildMapping(root,getParent);
        
        TreeNode startNode = dfs(root,startValue);
        
        boolean[] visited = new boolean[getParent.size()+1];
        List<Character> list = new ArrayList<>();
        
        getShortestPath(startNode,getParent,list,destValue,visited);
        return finalPath;
    }
    
    private void getShortestPath(TreeNode root, HashMap<Integer,TreeNode> getParent,List<Character> list,int destVal, boolean[] visited ){
        if(root.val == destVal){
            StringBuilder sb = new StringBuilder();
            for(char ch : list){
                sb.append(ch);
            }
            finalPath = sb.toString();
            return; 
        }
        
        visited[root.val] = true;
        list.add('L');
        if(root.left != null && visited[root.left.val] == false) getShortestPath(root.left,getParent,list,destVal,visited);
        list.remove(list.size()-1);
        list.add('R');
        if(root.right != null && visited[root.right.val] == false) getShortestPath(root.right,getParent,list,destVal,visited);
        list.remove(list.size()-1);
        list.add('U');
        if(getParent.get(root.val) != null && visited[getParent.get(root.val).val] == false) getShortestPath(getParent.get(root.val),getParent,list,destVal,visited);
        list.remove(list.size()-1);
        visited[root.val] = false;
    }
    
    private void parentChildMapping(TreeNode root,HashMap<Integer, TreeNode> getParent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                
                if(node.left != null){
                    queue.add(node.left);
                    getParent.put(node.left.val, node);
                }
                if(node.right != null){
                    queue.add(node.right);
                    getParent.put(node.right.val, node);
                }
            }
        }
    }
    
    private TreeNode dfs(TreeNode root,int startVal){
        if(root == null) return null;
        if(root.val == startVal) return root;
        
        TreeNode left = dfs(root.left,startVal);
        TreeNode right = dfs(root.right,startVal);
        
        if(left != null) return left;
        return right;
    }
}
