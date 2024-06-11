class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        hmap.put(0,-1);
        for(int i=0; i<n; i++){
            sum += nums[i];
            int rem = sum % k;
            if(hmap.containsKey(rem)){
                if(i - hmap.get(rem) >= 2){
                    return true;
                }
            }else{
                hmap.put(rem,i);
            }        
        }
        return false;
    }
}
