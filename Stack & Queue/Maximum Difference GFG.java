class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] nse_L = getNextSmallerOnLeft(arr,n);
        int[] nse_R = getNextSmallerOnRight(arr,n);
        
        int maxDiff = 0;
        for(int i=0; i<n; i++){
            maxDiff = Math.max(maxDiff, Math.abs(nse_L[i]-nse_R[i]));
        }
        
        return maxDiff;
    }
    
    private int[] getNextSmallerOnLeft(int[] arr, int n){
        int[] nse_L = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            int curr = arr[i];
            
            while(!st.isEmpty() && st.peek() >= curr){
                st.pop();
            }
            
            nse_L[i] = (st.isEmpty()) ? 0 : st.peek();
            st.push(arr[i]);
        }
        
        return nse_L;
    }
    
    private int[] getNextSmallerOnRight(int[] arr, int n){
        int[] nse_R = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            int curr = arr[i];
            
            while(!st.isEmpty() && st.peek() >= curr){
                st.pop();
            }
            
            nse_R[i] = (st.isEmpty()) ? 0 : st.peek();
            st.push(arr[i]);
        }
        
        return nse_R;
    }
}
