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
    public ListNode reverseList(ListNode head) {
        //reversing the linkedlist by using iterative approach:
        /*first we create a dummy node (newHead) with is null 
        then we make head.next element ele as a (next) 
        then we break the connection of the head with its next and point the head.next to the dummy node(null)
        then we make our current head as dummy node and our (next) as our (head)
        */
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