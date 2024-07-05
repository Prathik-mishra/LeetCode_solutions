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
// class Solution {
//     public int[] nodesBetweenCriticalPoints(ListNode head) {
//         int maxDist = 0, minDist = Integer.MAX_VALUE;
        
//         int i = 1, prevVal = head.val;
//         head = head.next;
//         int currCriticalPoint = 0, firstCriticalPoint = 0, prevCriticalPoint = 0;
        
//         while(head.next != null){
//             int currVal = head.val;
//             if((prevVal > currVal && currVal < head.next.val) || (prevVal < currVal && currVal > head.next.val)){
//                 if(firstCriticalPoint == 0){
//                     firstCriticalPoint = i;
//                     currCriticalPoint = i;
//                 }else{
//                     prevCriticalPoint = currCriticalPoint;
//                     currCriticalPoint = i;
//                     maxDist = currCriticalPoint - firstCriticalPoint;
//                     minDist = Math.min(minDist,currCriticalPoint - prevCriticalPoint);
//                 }
//             }
//             prevVal = head.val;
//             head = head.next;
//             i++;
//         }
        
//         if(minDist == Integer.MAX_VALUE){
//             return new int[]{-1,-1};
//         }
        
//         return new int[]{minDist,maxDist};
//     }
// }

//editorials solution for better comments : 
class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = { -1, -1 };

        // Initialize minimum distance to the maximum possible value
        int minDistance = Integer.MAX_VALUE;

        // Pointers to track the previous node, current node, and indices
        ListNode previousNode = head;
        ListNode currentNode = head.next;
        int currentIndex = 1;
        int previousCriticalIndex = 0;
        int firstCriticalIndex = 0;

        while (currentNode.next != null) {
            // Check if the current node is a local maxima or minima
            if (
                (currentNode.val < previousNode.val &&
                    currentNode.val < currentNode.next.val) ||
                (currentNode.val > previousNode.val &&
                    currentNode.val > currentNode.next.val)
            ) {
                // If this is the first critical point found
                if (previousCriticalIndex == 0) {
                    previousCriticalIndex = currentIndex;
                    firstCriticalIndex = currentIndex;
                } else {
                    // Calculate the minimum distance between critical points
                    minDistance = Math.min(
                        minDistance,
                        currentIndex - previousCriticalIndex
                    );
                    previousCriticalIndex = currentIndex;
                }
            }

            // Move to the next node and update indices
            currentIndex++;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // If at least two critical points were found
        if (minDistance != Integer.MAX_VALUE) {
            int maxDistance = previousCriticalIndex - firstCriticalIndex;
            result = new int[] { minDistance, maxDistance };
        }

        return result;
    }
}
