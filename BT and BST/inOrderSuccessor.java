/User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
          //add code here.
          Node successor = null;
          
          while(root != null){
              if(x.data >= root.data){
                  root = root.right;
              }else{
                  successor = root;
                  root = root.left;
              }
          }
          
          return successor;
         }
}
