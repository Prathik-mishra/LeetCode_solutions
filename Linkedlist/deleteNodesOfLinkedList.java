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
   public static Node deleteLast(Node list){
       // Write your code here
        Node temp  = list;

       // if the list has only one node

       if(temp.next == null){

           return list;

       }

       // we continue the loop till ((last node)-1)th node because 

       // in it next last node is present so we delete  

       while(temp.next.next != null){

           temp = temp.next;

       }

       temp.next = null;



       return list;
   }
}