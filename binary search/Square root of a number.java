class Solution {
    long floorSqrt(long n) {
        if(n == 1){
            return 1;
        }
        // Your code here
        long i=1, j=n-1;
        
        while(i<=j){
            long mid = (i+j)/2;
            
            if(mid * mid == n){
                return mid;
            }else if(mid * mid > n){
                j = mid-1;
            }else{
                i=mid+1;
            }
        }
        
        return j;
    }
}
