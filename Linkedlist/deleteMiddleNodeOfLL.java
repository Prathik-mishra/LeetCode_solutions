/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        
        while(fast != null && fast.next != null){
            prev = slow;       //here my prev is the storing the ele before middle ele
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
        
        //another approach using count: 
//         if (head == null || head.next == null)
//             return null;  

//         int count = 0;  
//         ListNode temp = head;

//         while (temp != null) {
//             count++;
//             temp = temp.next;
//         }

//         temp = head;
//         count = count / 2;  // Calculate the index of the middle node

//         // Traverse to the node just before the middle node
//         while (--count != 0) {
//             temp = temp.next;
//         }

//         temp.next = temp.next.next;
//         return head;
    }
}