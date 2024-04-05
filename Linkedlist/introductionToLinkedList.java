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
};

*****************************************************************/

public class Solution {
   public static Node constructLL(int []arr) {
       // Write your code here
       Node head = new Node(arr[0]);
       Node temp = head;

       for(int i=1; i<arr.length; i++){
           temp.next = new Node(arr[i]);
           temp = temp.next;
       }

       return head;
   }
}