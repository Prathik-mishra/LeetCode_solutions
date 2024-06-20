class Solution {
    public boolean isPossible(int[] position, int m,int mid){
        int ballsPlaced = 1,n = position.length;
        int prevPointer = 0;
        for(int i=1; i<n; i++){
            int diff = position[i] - position[prevPointer];
            
            if(diff >= mid){
                ballsPlaced++;
                prevPointer = i;
            }
        }
        
        return ballsPlaced >= m;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1, high = position[n-1];
        int ans = 0;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(isPossible(position,m,mid) == true){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return ans;
    }
}
