class Solution {
    public int longestOnes(int[] nums, int k) {
        //approach 1 : brute force generate all subarrays 
        //TC :- O(N^2) will give us a TLE
        
        //approach  2: basic dynamic sliding window TC:- 0(2*N)
        /*
        int i=0;
        int j=0;
        int n=nums.length;
        int maxLen = 0;
        while(j<n){
            if(nums[j] == 0){
                k--;
            }
            while(i<=j && k<0){ 
                if(nums[i] == 0){
                    k++;
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
        */
        
        //approach 3: optimised sliding window: 
        int i=0;
        int j=0;
        int n=nums.length;
        int maxLen = 0,zeros = 0;
        while(j<n){
            if(nums[j] == 0) zeros++;
            if(zeros > k){
                if(nums[i] == 0){
                    zeros--;
                }
                i++;
            }
            
            if(zeros<=k){
                int currLen = (j-i)+1;
                maxLen = Math.max(maxLen,currLen);
            }
            j++;
        }
        return maxLen;
    }
}
