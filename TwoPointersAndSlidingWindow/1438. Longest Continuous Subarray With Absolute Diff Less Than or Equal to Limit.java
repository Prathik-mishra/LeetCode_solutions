class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        // priorityQueue approach 1 :- O(n log n) time and O(n) space 
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x,y) -> -Integer.compare(x.num,y.num));
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((x,y) -> Integer.compare(x.num,y.num));
        
        int left = 0;
        int maxLen = 0;
        
        for(int right=0; right<nums.length; right++){
            maxHeap.add(new Pair(nums[right],right));
            minHeap.add(new Pair(nums[right],right));
            
            if(maxHeap.peek().num - minHeap.peek().num > limit){
                left = Math.min(maxHeap.peek().idx,minHeap.peek().idx) + 1;
                
                //remove the elements from the heaps:
                while(maxHeap.peek().idx < left){
                    maxHeap.poll();
                }
                
                while(minHeap.peek().idx < left){
                    minHeap.poll();
                }
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}

class Pair{
    int num;
    int idx;
    public Pair(int x,int y){
        this.num = x;
        this.idx = y;
    }
}
