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
    public int pairSum(ListNode head) {
        //approach 1:
        /*
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode temp = head;
        
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        
        int maxInteger = Integer.MIN_VALUE;
        for(int i=0; i<(list.size()/2); i++){
            maxInteger = Math.max(maxInteger,list.get(i)+list.get(list.size()-i-1));       
        }
        
        return maxInteger;
        */
        
        //approach 2:
        ListNode slow = head;
        ListNode fast = head;
        int maxVal = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        while (prev != null) {
            maxVal = Math.max(maxVal, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return maxVal;
        
        
    }
}