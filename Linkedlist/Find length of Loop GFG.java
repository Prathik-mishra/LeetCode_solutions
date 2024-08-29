class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        
        if(!isCycle){  //cycle doesnt exists
            return 0;
        }
        
        int len = 1;
        fast = fast.next;
        
        while(fast != slow){
            len++;
            fast = fast.next;
        }
        
        return len;
    }
}
