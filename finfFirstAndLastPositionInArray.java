class Solution {
    private int findFirstOccur(int arr[], int n,int k){
		int start = 0;
		int end = n-1;

		int ans = n;
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] == k){
				ans = Math.min(ans,mid);
				end = mid-1;
			}else if(arr[mid] < k){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		if(ans == n){
			return -1;
		}
		return ans;
	}

	private int findLastOccur(int arr[], int n,int k){
		int start = 0;
		int end = n-1;

		int ans = -1;
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] == k){
				ans = Math.max(ans,mid);
				start = mid+1;
			}else if(arr[mid] < k){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		
		return ans;
	}
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] ans = new int[2];
        int n = nums.length;
        //using binary search get the answers for the functions
        ans[0] = findFirstOccur(nums, n, target);
	    ans[1] = findLastOccur(nums, n, target);
        return ans;
    }
}