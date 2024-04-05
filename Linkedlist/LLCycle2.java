/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
        2(x+y) - (x+y) = NC
        
        this is the formula that states that we the slow covers
        a distance the fast covers the length of the linkedList 
        the fast covers the 2*length of the linkedlist that is 
        the point where the two pointers meet if the cycle is getting repeated
        */
        
//         if(head == null || head.next == null) return null;
        
//         ListNode slow = head;
//         ListNode fast = head;
        
//         while(fast != null &&  fast.next != null){
//             fast = fast.next.next;
//             slow = slow.next;
//             if(fast == slow) break;
//         }
        
//         if(fast == null || fast.next == null) return null;
        
//         while(slow != head){
//             slow = slow.next;
//             head = head.next;
//         }
        
//         return head;
        
        
        //another way to write the same code:
        
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){                                //entry point is decected 
                while(slow != entry){                        //running a loop till the collision occurs
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}