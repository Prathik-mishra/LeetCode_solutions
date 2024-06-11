class Solution {
    public int subarraySum(int[] nums, int k) {
        //brute force: 
        // int count = 0;
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     int sum = 0;
        //     for(int j=i;j<n; j++){
        //         sum += nums[j];
        //         if(sum == k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        
        //optimal hashmap approach: 
        int count=0;
        int n=nums.length;
        Map<Integer,Integer> prefixSumCounts = new HashMap<>();
 
        int sum=0;
        prefixSumCounts.put(0,1);  //the most siginificant line in code
        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(prefixSumCounts.containsKey(sum-k)) count+=prefixSumCounts.get(sum-k);
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
