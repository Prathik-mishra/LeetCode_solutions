class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0,high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            int missing = (arr[mid] - (mid + 1));
            if(missing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high+k+1; //(or) low+1; because high+1 is low since they cross each other at the final point  
    }
}