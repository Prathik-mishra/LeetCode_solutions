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
        
        
        return atMost(nums,goal) - atMost(nums,goal-1);
    }
    
    public int atMost(int[] nums,int k){
        if(k < 0) return 0;
        
        int i=0,j=0,n=nums.length,count=0,sum=0;
        while(j<n){
            sum += nums[j];
            while(i<=j && sum > k){
                sum -= nums[i++];
            }
            
            count += (j-i+1);
            j++;
        }
        return count;     
    }
}