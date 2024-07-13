class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int[] nse_L = nseL_fun(arr);
        int[] nse_R = nseR_fun(arr);
        int count = getSumSubArrayMinimums(nse_L,nse_R,arr);
        
        return count;
    }
    
    //for finding the nextGreaterOnLeft 
    public static int[] nseL_fun(int[] arr){
        int n = arr.length;
        int[] nseL = new int[n];
        Stack<Pair> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            int count = 1;
            
            while(!st.isEmpty() && st.peek().element > arr[i]){
                count += st.peek().count;
                st.pop();
            }
            
            nseL[i] = count;
            st.push(new Pair(arr[i],count));
        }
        
        return nseL;
    } 
    
    //for finding the nextGreaterOnLeft 
    public static int[] nseR_fun(int[] arr){
        int n = arr.length;
        int[] nseR = new int[n];
        Stack<Pair> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            int count = 1;
            
            while(!st.isEmpty() && st.peek().element >= arr[i]){
                count += st.peek().count;
                st.pop();
            }
            
            nseR[i] = count;
            st.push(new Pair(arr[i],count));
        }
        
        return nseR;
    } 
    
    //for getting the Sum of SubArray Minimuns
    public static int getSumSubArrayMinimums(int[] nse_L, int[] nse_R,int[] arr){
        long m = 1000000007;
        long n = arr.length;
        long count = 0;
        
        for(int i=0; i<n; i++){
            long noOfSubArrays = ((nse_L[i]%m) * (nse_R[i]%m))%m;
            long answer = ((noOfSubArrays%m) * (arr[i]%m))%m;
            
            count = ((count%m) + (answer%m))%m;
        }
        
        return (int)count;
    }
}

//Pair class
class Pair{
    int element;
    int count;
    public Pair(int x,int y){
        this.element = x;
        this.count = y;
    }
}


/*
same approach different code
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse_R = new int[n];
        int[] nse_L = new int[n];
        
        //step 1: finding the next smaller element on left;
        Stack<Integer> st1 = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            
            while(!st1.isEmpty() && arr[st1.peek()] >= arr[i]){
                st1.pop();
            }
            
            nse_L[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }
        
        //step 2: finding the next smaller element on right;
        Stack<Integer> st2 = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i--){
            
            while(!st2.isEmpty() && arr[st2.peek()] > arr[i]){
                st2.pop();
            }
            
            nse_R[i] = st2.isEmpty() ? n : st2.peek();
            st2.push(i);
        }
        
        //step 3: how to find out how many subarrays current element can be the minimum element:
        long minSum = 0;
        long m = 1000000007;
        
        for(int i = 0 ; i < n ; i++){
            //taking long to avoid overflow: 
            
           
            // here if left has no elements then the count becomes 1 because 
            // id i = 0 ans nse_l = -1 then 0 - (-1) = 1
            // so as the right condition nse_R = n and i = n-1 then 
            // n = 5 and nse_R = 4 = 5-4 = 1
            
            long startingPoint = i - nse_L[i];
            long endingPoint = nse_R[i] - i;
            
            long noOfSubarrays = (startingPoint%m * endingPoint%m)%m;
            long answer = (noOfSubarrays%m * arr[i]%m)%m;
            
            minSum = (minSum%m + answer%m)%m;
        }
        
        return (int)minSum;
    }
}
*/
