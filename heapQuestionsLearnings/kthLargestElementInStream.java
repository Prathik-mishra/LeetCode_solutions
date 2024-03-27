class KthLargest {

    PriorityQueue<Integer> minHeap;
    int size;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        size = k;
        for(int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
            
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < size){
            minHeap.add(val);
        }else{
            if(minHeap.peek() < val){
                minHeap.remove();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
