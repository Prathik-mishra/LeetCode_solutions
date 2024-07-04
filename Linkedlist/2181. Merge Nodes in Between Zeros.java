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
    public ListNode mergeNodes(ListNode head) {
        //itterative solution : 
        // ListNode newHead = new ListNode(0);
        // ListNode temp1 = newHead;
        // ListNode temp = head.next;
        // int sum = 0;
        // while(temp != null){
        //     if(temp.val == 0){
        //         ListNode newNode = new ListNode(sum);
        //         temp1.next = newNode;
        //         temp1 = temp1.next;
        //         sum = 0;
        //     }
        //     sum += temp.val;
        //     temp = temp.next;
        // }
        // return newHead.next;
        
        // Start with the first non-zero value.
        head = head.next;
        if (head == null) {
            return head;
        }

        //recursive solution : 
        // Initialize a dummy head node.
        ListNode temp = head;
        int sum = 0;
        while (temp.val != 0) {
            sum += temp.val;
            temp = temp.next;
        }

        // Store the sum in head's value.
        head.val = sum;
        // Store head's next node as the recursive result for temp node.
        head.next = mergeNodes(temp);
        return head;
    }
}
