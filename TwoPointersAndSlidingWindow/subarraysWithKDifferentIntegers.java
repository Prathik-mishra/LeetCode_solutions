class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    public int atMost(int[] nums,int k){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int j=0,i=0,count=0;
        
        while(j<nums.length){
            hmap.put(nums[j],hmap.getOrDefault(nums[j],0)+1);
            
            while(i <= j && hmap.size() > k){
                hmap.put(nums[i],hmap.getOrDefault(nums[i],0)-1); 
                if(hmap.get(nums[i]) == 0){
                    hmap.remove(nums[i]);
                } 
                i++;
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
}
