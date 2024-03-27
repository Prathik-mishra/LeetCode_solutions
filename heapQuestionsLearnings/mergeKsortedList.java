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
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0) return null;
            
            PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));
            
            for(ListNode list : lists){
                ListNode temp = list;
                while(temp != null){
                    queue.add(temp);
                    temp = temp.next;
                }
            }
        
            ListNode head = new ListNode(0);
            ListNode runner = head;
            
            while(!queue.isEmpty()){
                ListNode node = queue.remove();
                node.next = null;
                runner.next = node;
                runner = runner.next;
            }
            
            
            return head.next;                    
        }
    }