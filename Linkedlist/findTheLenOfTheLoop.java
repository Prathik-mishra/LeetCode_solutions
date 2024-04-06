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

public class Solution
{
   public static int lengthOfLoop(Node head) {
       // Write your code here
       if(head == null || head.next == null) return 0;
       Node slow = head;
       Node fast = head;
       boolean cycle = false;
       while(fast != null){
           slow = slow.next;
           fast = fast.next.next;

           if(slow == fast) {
               cycle = true;
               break;
           }
       }

       if(cycle == false) return 0;
       Node start = head;
       while(start != slow){
           start = start.next;
           slow = slow.next;
       }

       int cycleLen = 1;
       Node temp = start.next;
       while(temp != start){
           temp = temp.next;
           cycleLen++;
       }

       return cycleLen;

   }
}