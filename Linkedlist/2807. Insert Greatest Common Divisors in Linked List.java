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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode runner = head;

        while(runner.next != null){
            ListNode next = runner.next;
            int val1 = runner.val;
            int val2 = next.val;

            ListNode gcdNode = new ListNode(gcd(val1,val2));
            
            runner.next = gcdNode;
            gcdNode.next = next;
            runner = runner.next.next;
        }

        return head;
    }

    private int gcd(int val1, int val2){
        if(val2 == 0){
            return val1;
        }

        return gcd(val2, val1 % val2);
    }
}
