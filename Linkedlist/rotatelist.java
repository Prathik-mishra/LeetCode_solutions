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
    public ListNode getTail(ListNode head,int len){
        int count = 0;
        while(head.next != null){
            count++;
            if(count == len) {
                break;
            }
            head = head.next;
        }
        return head;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        //if len is zero:
        if(head == null || head.next == null || k == 0) return head;
        
        int len = 1;
        ListNode tail = head;
        
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        tail.next = head;
        
        //edge case: since there will be zero rotations left to do so return head
        if(k % len == 0){
            tail.next = null;
            return head;
        }
        k = k % len;
        
        ListNode newTail = getTail(head,len - k);
        head = newTail.next;
        newTail.next = null;
        
        return head;
    }
}
