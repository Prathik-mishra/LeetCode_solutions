class Solution {
    public void preOrder(TreeNode node,ArrayList<String> ans, String s){
        if(node.left == null && node.right == null){
            ans.add(s);
            return;
        }
        
        preOrder(node.left,ans,s+"0");
        preOrder(node.right,ans,s+"1");
    }
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<TreeNode> queue = new PriorityQueue<>((a,b)-> {
            if(a.data == b.data){
                return 1;
            }
            return a.data - b.data;
        });
        for(int i=0; i<N; i++){
            TreeNode node = new TreeNode(f[i]);
            queue.add(node);
        }
        

        while(queue.size() > 1){
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            
            TreeNode newNode = new TreeNode(left.data+right.data);
            newNode.left = left;
            newNode.right = right;
            queue.add(newNode);
        }
        
        ArrayList<String> ans = new ArrayList<>();
        String s = "";
        TreeNode node = queue.remove();
        preOrder(node,ans,s);
        return ans;
    }
}
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        this.data = x;
        this.left = null;
        this.right = null;
    }
}
