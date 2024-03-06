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
    public boolean hasCycle(ListNode head) {
        /* in the sol also we use a Tortoisehare method algo which is 
        having a two pointer a small which moves one step and a fast 
        which moves two steps w.r.t slow so that they are bound to 
        collide if their exists a cycle otherwise the loop breaks and
        we return false
        */
        if(head == null || head.next == null) return false;
        
        ListNode fast = head,slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
