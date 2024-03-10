class Solution {
    boolean isPossible(int[] arr,int mid, int m, int k){
        int noOfFlowersBloomed = 0;
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= mid) cnt++;
            else{
                noOfFlowersBloomed += (cnt/k);
                cnt = 0;
            }
        }
        //for the left over cnt the below line is must
        noOfFlowersBloomed += (cnt/k);
        return (noOfFlowersBloomed >= m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;
        //edge Case if the size is lessthan the required number of flowers multiplied to bouquets then it is not possible so return -1
        if(n < m*k) return -1;
        
        // step 1: Find out the range
        // step 2: preform binary search in that range
        // step 3: find the possibility of the answer is correct or not
        
        int minValue = bloomDay[0];
        int maxValue = bloomDay[0];
        for(int i=1; i<n; i++){
            minValue = Math.min(minValue,bloomDay[i]);
            maxValue = Math.max(maxValue,bloomDay[i]);
        }
        int low = minValue;
        int high = maxValue;
        int ans = -1;
        
        while(low <= high){
            int mid = (low+high)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
