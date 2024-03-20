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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //get the node infront of first nth node Lets Say checkNode1
        //get the node behind the second nth node Lets Say checkNode2
        //get the 2nd listnodes tail node which is not null say newListTail
        
        ListNode temp = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        
        ListNode newListTail = temp;
        ListNode newListHead = list2;
        
        temp = list1;
        ListNode insertnewHeadFront = null;
        ListNode insertnewTailBack = null;
        int count = 0;
        
        while(temp != null){
            if(count == a-1){
                insertnewHeadFront = temp;
            }
            if(count == b+1){
                insertnewTailBack = temp;
            }
            temp = temp.next;
            count++;
        }
        
        insertnewHeadFront.next = newListHead;
        newListTail.next = insertnewTailBack;
        
        return list1;
    }
}