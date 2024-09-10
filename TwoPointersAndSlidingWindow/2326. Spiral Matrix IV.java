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
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int left = 0;
        int top = 0;
        int bottom = n-1;
        int right = m-1;
        int[][] spiral = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(spiral[i],-1);
        }
        
        while(top<=bottom && left<=right){
            //this is for travilling in left to right direction: 
            for(int i = left ; i <= right ; i++){
                if(head == null) continue;
                spiral[top][i] = head.val;
                head = head.next;
            }
            top++;
            //this is for travelling in top to bottom direction in right most side of the matrix: 
            for(int i = top ; i <= bottom ; i++){
                if(head == null) continue;
                spiral[i][right] = head.val;
                head = head.next;
            }
            right--;
            //this is for moving in right to left direction in bottom most row of the matrix:
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                if(head == null) continue;
                spiral[bottom][i] = head.val;
                head = head.next;
            }
            bottom--; 
            }
           
            //this is for moving in bottom to top direction in the left most side of the matrix:
            if(left <= right){
               for(int i = bottom ; i >= top ; i--){
                if(head == null) continue;
                spiral[i][left] = head.val;
                head = head.next;
            }
            left++;  
            }
        }
        return spiral;
    }
}
