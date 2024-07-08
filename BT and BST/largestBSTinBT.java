// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Pair{
    int size;
    int largestVal;
    int smallestVal;
    public Pair(int _size,int _largestVal,int _smallestVal){
        this.size = _size;
        this.largestVal = _largestVal;
        this.smallestVal = _smallestVal;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return getLargestBst(root).size;
    }
    
    static Pair getLargestBst(Node root){
        if(root == null){
            return new Pair(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        
        Pair left = getLargestBst(root.left);
        Pair right = getLargestBst(root.right);
        
        if(left.largestVal < root.data && root.data < right.smallestVal){
            return new Pair(1+left.size+right.size,
                            Math.max(right.largestVal,root.data),
                            Math.min(left.smallestVal,root.data));
        }else{
            return new Pair(Math.max(left.size,right.size),
                            Integer.MAX_VALUE,
                            Integer.MIN_VALUE);
        }
    }
    
}
