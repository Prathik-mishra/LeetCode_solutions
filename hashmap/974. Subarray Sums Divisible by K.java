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
