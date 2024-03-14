class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse_L = nextSmallestOfLeft(heights,n);
        int[] nse_R = nextSmallestOfRight(heights,n);
        int maxHisto = 0;
        
        for(int i = 0 ; i < n ; i++){
            maxHisto = Math.max(maxHisto,(nse_R[i] - nse_L[i] + 1) * heights[i]);
        }
        
        return maxHisto;
    }
    
    private static int[] nextSmallestOfLeft(int[] heights, int n){
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i < n ; i++){
            
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            
            ans[i] = stack.isEmpty() ? 0 : stack.peek()+1;
            stack.push(i);
        }
        return ans;
    }
    
    private static int[] nextSmallestOfRight(int[] heights, int n){
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n-1 : stack.peek()-1;
            stack.push(i);
        }
        return ans;
        
        //most optimal approach: 
        
    }
}