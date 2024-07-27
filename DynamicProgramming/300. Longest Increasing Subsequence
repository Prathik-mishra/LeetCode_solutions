class Solution {
    public int lengthOfLIS(int[] nums) {
        //tabulation approach :
        // int size = nums.length;
        // int max = Integer.MIN_VALUE;
        // int[] dp = new int[size];
        // dp[0] = 1;
        // for(int i=1; i<size; i++){
        //     int maxi = 0;
        //     for(int j=i-1; j>=0; j--){
        //         if(nums[i] > nums[j]){
        //             maxi = Math.max(maxi,dp[j]);
        //         }
        //     }
        //     dp[i] = 1 + maxi;
        //     max = Math.max(max,dp[i]);
        // }
        // return max == Integer.MIN_VALUE ? 1 : max;   
        
//         binary search approach: 
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(nums[0]);
//         int len = 1;
        
//         for(int i=1; i<nums.length; i++){
//             if(list.get(len-1) < nums[i]){
//                 list.add(nums[i]);
//                 len++;
//             }else{
//                 //binary search for inserting/replace the element:
//                 int getIdx = binarySearch(list,0,len-1,nums[i]);
//                 list.set(getIdx,nums[i]);
//             }
//         }
//         return list.size();
        
        //TreeSet approach: 
        TreeSet<Integer> tset = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Integer getNum = tset.ceiling(nums[i]);
            if(getNum != null){
                tset.remove(getNum);
            }
            tset.add(nums[i]);
        }
        return tset.size();
        
    }
    public int binarySearch(ArrayList<Integer> list,int low,int high,int x){
        int mid;
	    while (low <= high) {
		    mid = low + (high - low) / 2;
		    if (list.get(mid) == x)
			    return mid;
		    else if (list.get(mid) > x)
			    high = mid - 1;
		    else
			    low = mid + 1;
        }
	    return low;     
    }
}








//         Stack<Integer> st = new Stack<>();
//         int n = nums.length;
        
//         for(int i=0; i<n; i++){
//             int num = nums[i];
//             while(!st.isEmpty() && st.peek() >= num){
//                 st.pop();
//             }
//             st.add(num);
//         }
        
//         return st.size();
