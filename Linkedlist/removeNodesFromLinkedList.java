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
    public ListNode removeNodes(ListNode head) {
        
        //approach 1: using monotonic stack TC :- O(N*N*N) SC :- O(N*N)
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        
        while(temp != null){
            while(!st.isEmpty() && st.peek().val < temp.val){
                st.pop();
            }
            st.push(temp);
            temp = temp.next;
        }
        
        Stack<ListNode> reverse = new Stack<>();
        while(!st.isEmpty()){
            reverse.push(st.pop());
        }
        
        ListNode newHead = new ListNode(0);
        temp = newHead;
        
        while(!reverse.isEmpty()){
            temp.next = reverse.pop();
            temp = temp.next;
        }
        
        return newHead.next;
    }
}
