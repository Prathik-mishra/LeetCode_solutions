class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rem = 0;
        int sum = 0;
        int res = 0;
        
        map.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            rem = sum % k;
            if(rem < 0){   //for avoiding the negative cases
                rem += k;
            }
            
            if(map.containsKey(rem)){
                res += map.get(rem);
                map.put(rem,map.get(rem) + 1);
            }else{
                map.put(rem,1);
            }
        }
        return res;
    }
}

/* calculation :
    pb - pa = k 
    where pb is prefixSum at b and pa is prefixSum at a and k is the prefixSum in range pa+1 to pb
    -> pb - pa = k 
    
    -> pb%x - pa%x = k%x
    
    -> (pb - pa)%x = 0
    
    -> pb%x = pa%x   --> final expression so if we have a reminder present in hashmap before then we will have a subarray sum divisible by k.
    
    // to avoid negative cases 
    if rem < 0 add + x to the rem 
    */
