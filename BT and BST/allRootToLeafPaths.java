public class Solution {
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        getPaths(root,ans,"");
        return ans;
    }

    public static void getPaths(BinaryTreeNode root,List<String> lis,String str){
        if(root.left == null && root.right == null){
            lis.add(str);
        }

        getPaths(root.left,lis,str+root.data+" ");
        getPaths(root.right,lis,str+root.data+" ");
    }
}
