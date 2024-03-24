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
    public void reorderList(ListNode head) {
        //first get the middle element
        //reverse the list from the middle element
        //start rearranging the nodes
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        slow = reverse(newHead);
        
        ListNode dummy = new ListNode(0);
        fast = head;
        
        while(fast != null){
            dummy.next = fast;
            fast = fast.next;
            dummy = dummy.next;
            
            if(slow != null){
                dummy.next = slow;
                slow = slow.next;
                dummy = dummy.next; 
            }     
        }
        
        head = dummy.next;
    }
    
    public ListNode reverse(ListNode head){
        ListNode newHead = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        
        return newHead;
    }
}