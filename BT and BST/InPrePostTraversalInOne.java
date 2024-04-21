/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        while(!st.isEmpty()){

            Pair it = st.pop();

            if(it.num == 1){
                pre.add(it.node.data);
                st.push(new Pair(it.node,2));

                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }else if(it.num == 2){
                in.add(it.node.data);
                st.push(new Pair(it.node,3));

                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }else{
                post.add(it.node.data);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(in);
        result.add(pre);
        result.add(post);
        return result;
    }
}
class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode _node,int _num){
        this.node = _node;
        this.num = _num;
    }
}
