/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

// class Solution
// {
//     //Function to return a list of nodes visible from the top view 
//     //from left to right in Binary Tree.
//     static ArrayList<Integer> topView(Node root)
//     {
//         // add your code
//         ArrayList<Integer> ans = new ArrayList<>();
//         hmap = new TreeMap<>();
//         recur(root,0,0);
//         for(Integer key: hmap.keySet()){
//             ans.add(hmap.get(key).get(1));
//         }
//         return ans;
//     }
    
//     static TreeMap<Integer,ArrayList<Integer>> hmap;
//     private static void recur(Node root,int verticalLvl,int horizontalLvl){
//         if(root == null) {
//             return;
//         }
        
//         if(hmap.containsKey(verticalLvl) == false){
//             ArrayList<Integer> list = new ArrayList<>();
//             list.add(horizontalLvl);
//             list.add(root.data);
//             hmap.put(verticalLvl,list);
//         }else{
//             if(horizontalLvl < hmap.get(verticalLvl).get(0)){
//                 ArrayList<Integer> list = new ArrayList<>();
//                 list.add(horizontalLvl);
//                 list.add(root.data);
//                 hmap.put(verticalLvl,list);
//             }
//         }
        
//         recur(root.left,verticalLvl-1,horizontalLvl+1);
//         recur(root.right,verticalLvl+1,horizontalLvl+1);
//     } 
// }



//further more:

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

import java.util.ArrayList;
import java.util.TreeMap;

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    private static TreeMap<Integer,ArrayList<Integer>> map;
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        map = new TreeMap<>();
        helper(root,0,0);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int vLvl : map.keySet()){
            ans.add( map.get(vLvl).get(1));
        }
        return ans;
    }

    private static void helper(Node node,int horizontal,int vertical){
        if(node == null){
            return;
        }

        //logic:
        if(map.containsKey(vertical)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(horizontal);
            list.add(node.data);
            map.put(vertical,list);
        }else if(horizontal < map.get(vertical).get(0)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(horizontal);
            list.add(node.data);
            map.put(vertical,list);
        }

        helper(node.left,horizontal+1,vertical-1);
        helper(node.left,horizontal+1,vertical+1);
    }
}