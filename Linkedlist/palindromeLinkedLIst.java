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
    public static ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        //finding out the middle element:
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reversing the elements after the middle element i.e., slow.next: 
        slow.next = reverse(slow.next);
        slow = slow.next;
        ListNode dummy = head;
        
        //for finding wheather the linkedlist is palindrome or not: 
        while(slow!=null){
            if(slow.val != dummy.val) return false;
            slow = slow.next;
            dummy = dummy.next;
        }
        return true;
    }
}
