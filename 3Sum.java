class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> triplet = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else{
                    List<Integer> trip = new ArrayList<>();
                    trip.add(nums[i]);
                    trip.add(nums[j]);
                    trip.add(nums[k]);
                    triplet.add(trip);
                    // triplet.add(Arrays.asList(nums[i],nums[j],nums[k]));// this way it has more TC
                    j++;
                    k--;
                    while(j<k && nums[j-1] == nums[j]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return triplet;
    }
}
