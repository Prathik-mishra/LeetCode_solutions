class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //using itteritive way to do the traversal:
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            list.add(node.val);
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return list;
    }
}
