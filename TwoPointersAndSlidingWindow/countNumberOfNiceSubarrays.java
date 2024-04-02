class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        /*
        int oddcount=0;
        int res=0;
        int i=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2==1){
                oddcount++;
                count=0;
            }
            while(oddcount==k){
                if(nums[i++]%2==1) oddcount--;
                count++;
            }
            res+=count;
        }
        return res;
        */
        
        return atMost(nums,k) - atMost(nums,k-1);
    }
    
    public int atMost(int[] nums,int k){
        if(k < 0) return 0;
        
        int i=0,j=0,n=nums.length,count=0,sum=0;
        while(j<n){
            sum += nums[j]%2;
            while(i<=j && sum > k){
                sum -= nums[i++]%2;
            }
            
            count += (j-i+1);
            j++;
        }
        return count;     
    }
}
