/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class Tree
{
    private static int count;
    //Function to count number of subtrees having sum equal to given sum.
    int countSubtreesWithSumX(Node root, int X)
    {
	    //Add your code here.
	    count = 0;
	    helper(root,X);
	    return count;
	    
    }
    
    private int helper(Node root,int X){
        if(root == null){
	        return 0;
	    }
	    
	    int leftSubTree = helper(root.left,X);
	    int rightSubTree = helper(root.right,X);
	    
	    if(leftSubTree+rightSubTree+root.data == X){
	        count++;
	        return leftSubTree+rightSubTree+root.data;
	    }else{
	        return leftSubTree+rightSubTree+root.data;
	    }
    }
}
