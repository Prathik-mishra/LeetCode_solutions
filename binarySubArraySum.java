class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        /*
        //approach 1: using hashmap and looking back for previous prefix sums
        // TC :- O(N) ans SC :- O(N)
        
        int count = 0,prefix = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        
        hmap.put(0,1);   //if at any time the prefix becomes k then this 0 will help to contribute to the count because prefix if becomes k then k - k will give us zero
        
        for(int i=0; i<nums.length; i++){
            prefix += nums[i];
            if(hmap.containsKey(prefix-goal)){
                count += hmap.get(prefix-goal);
            }
            hmap.put(prefix, hmap.getOrDefault(prefix,0)+1);
        }
        return count;    
        */
        
        
        int start = 0;
        int prefixZeros = 0;
        int currentSum = 0;
        int totalCount = 0;

        // Loop through the array using end pointer
        for (int end = 0; end < nums.length; end++) {
            // Add current element to the sum
            currentSum += nums[end];
            
            // Slide the window while condition is met
            while (start < end && (nums[start] == 0 || currentSum > goal)) {
                if (nums[start] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros++;
                }
                
                currentSum -= nums[start];
                start++;
            }
            
            // Count subarrays when window sum matches the goal
            if (currentSum == goal) {
                totalCount += 1 + prefixZeros;
            }
        }
        
        return totalCount;
    }
}