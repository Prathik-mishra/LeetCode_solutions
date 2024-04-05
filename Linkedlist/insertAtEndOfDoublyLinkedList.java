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
   public static Node insertAtTail(Node list, int K) {
       // Write your code here
       if(list == null){
           return new Node(K);
       }
       Node temp = list;
       while(temp.next != null){
           temp = temp.next;
       }
       Node newNode = new Node(K);
       temp.next = newNode;
       newNode.prev = temp;
       return list;
   }
}