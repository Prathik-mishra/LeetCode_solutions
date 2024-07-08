class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }else{
                
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                
                //make the threaded connection if already exist then add in the list and break it
                if(prev.right == null){
                    prev.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }
