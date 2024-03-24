class Solution {
    public int minOperations(int k) {
        int minOperations = k-1;
        
        for(int i=1; i<=k; i++){
           int currOperation = i-1; 
            if(k%i == 0){
               currOperation += Math.floor(k/i)-1; 
            }else{
                currOperation += Math.floor(k/i);
            }   
           minOperations = Math.min(currOperation,minOperations);
        }
        
        return minOperations;
    }
}