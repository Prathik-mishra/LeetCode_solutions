class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //brute approach
        // int arr[] = new int[2];
        // for(int i = 0 ; i < nums.length-1 ; i++){
        //     for(int j = i+1 ; j < nums.length ; j++){
        //         if(nums[i]+nums[j]==target){
        //             arr[0] = i;
        //             arr[1] = j;
        //         }
        //     }
        // }
        // return arr;
        
        //HashMap approach: -> better sol
        if(nums == null)
	    		return null;
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return result;
        
    }
}