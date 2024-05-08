class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static ArrayList<Integer> lis;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        lis = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        getPaths(root,list);
        return list;
    }
    
    public static void getPaths(Node root,ArrayList<ArrayList<Integer>> list){
        lis.add(root.data);
        if(root.left == null && root.right == null){
            list.add(new ArrayList<>(lis));
        }else{
            if(root.left != null){
                getPaths(root.left,list);
            }
            if(root.right != null){
                getPaths(root.right,list);
            }
        }
        lis.remove(lis.size()-1);
    }
}
