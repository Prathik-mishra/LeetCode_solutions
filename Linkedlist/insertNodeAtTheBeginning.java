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

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
        this.prev = next;
    }
};

*****************************************************************/

public class Solution
{
   public static Node insertAtFirst(Node list, int newValue) {
       // Write your code here
       Node newHead = new Node(newValue);
       newHead.next = list;
       return newHead;
   }
}