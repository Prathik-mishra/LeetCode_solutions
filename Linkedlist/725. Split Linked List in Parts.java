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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getListSize(head);

        int extraSizeParts = size%k;
        int parts = size/k;
        ListNode[] partsList = new ListNode[k];
        ListNode temp = head;

        int idx = 0;

        while(idx < k){
            int currentPartSize = idx+1 <= extraSizeParts ? parts+1 : parts;
            ListNode currentList = new ListNode(0);
            ListNode runner = currentList;

            while(currentPartSize-- > 0){
                currentList.next = new ListNode(temp.val);
                temp = temp.next;
                currentList = currentList.next;
            }

            partsList[idx++] = runner.next;
        }

        return partsList;
    }

    private int getListSize(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        } 
        return count;
    }
}
