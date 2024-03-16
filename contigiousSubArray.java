class Solution {
    public int findMaxLength(int[] nums) {
        //brute force n^2 approach:
        /*
        int maxSize = 0,n = nums.length;
        
        for(int i=0; i<n; i++){
            int zeros = 0;
            int ones = 0;
            for(int j=i; j<n; j++){
                if(nums[j] == 0){
                    zeros++;
                }else{
                    ones++;
                }
                
                if(zeros == ones && j != i){
                    maxSize = Math.max(maxSize,j-i+1);
                }
            }
        }
        return maxSize;
        */
        
        //2nd approach using hashmap:
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1); // since the count is zero before idx -1 it has a major significance in further process
        
        int maxLen = 0, count = 0;
        
        for(int i=0; i<nums.length; i++){
            count += (nums[i] == 0 ? -1 : 1);
            
            if(hmap.containsKey(count)){
                maxLen = Math.max(maxLen, i - hmap.get(count));
            }else{
                hmap.put(count,i);
            }
        }
        
        return maxLen;
    }
}
