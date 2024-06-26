class Node {
    public int data;
    public Node next;
   
    Node()
    {
        this.data = 0;
        this.next = null;
    }
   
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
   
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

*****************************************************************/

public class Solution {
   public static int length(Node head){
       //Your code goes here
       int count = 0;
       Node temp = head;
       while(temp != null){
           count++;
           temp = temp.next;
       }
       return count;
   }
}