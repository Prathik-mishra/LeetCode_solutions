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

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> boundaryTraversal = new ArrayList<>();
	    if(isLeaf(node) == false) boundaryTraversal.add(node.data);
	    leftBoundary(node,boundaryTraversal);
	    leafBoundary(node,boundaryTraversal);
	    rightBoundary(node,boundaryTraversal);
	    
	    return boundaryTraversal;
	}
	
	private boolean isLeaf(Node node){
	    return ((node.left == null) && (node.right == null)) ? true : false;
	}
	
	private void leftBoundary(Node node,ArrayList<Integer> list){
	    if(node == null) return;
	    node = node.left;
	    while(node != null){
	        if(isLeaf(node) == false) list.add(node.data);
	        if(node.left != null) node = node.left;
	        else node = node.right;
	    }
	}
	
	private void leafBoundary(Node node,ArrayList<Integer> list){
	    if(isLeaf(node)){
	        list.add(node.data);
	        return;
	    }
	    
	    if(node.left != null) leafBoundary(node.left,list);
	    if(node.right != null) leafBoundary(node.right,list);
	}
	
	private void rightBoundary(Node node,ArrayList<Integer> list){
	    if(node == null) return;
	    node = node.right;
	    ArrayList<Integer> rightTraversal = new ArrayList<Integer>();
	    while(node != null){
	        if(isLeaf(node) == false) rightTraversal.add(node.data);
	        if(node.right != null) node = node.right;
	        else node = node.left;
	    }
	    
	    for(int i=rightTraversal.size()-1; i>=0; i--){
	        list.add(rightTraversal.get(i));
	    }
	}
}
