class Node {
    public int data;
    public Node next;
    public Node prev;

    Node()
    {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
};

*****************************************************************/

public class Solution
{
   public static Node deleteLastNode(Node head) {
       // Write your code here
       if(head.next == null){
           return null;
       }

       Node temp = head;
       while(temp.next.next != null){
           temp = temp.next;
       }

       temp.next = null;
       return head;
   }
}
