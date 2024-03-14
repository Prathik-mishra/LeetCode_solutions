class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    
        int[] height = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestRectangleArea(height);
        for(int i = 1; i < matrix.length; i++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestRectangleArea(height));
        }
    
        return result;
    }
    //this function returns the new hight of the array: 
    private void resetHeight(char[][] matrix, int[] height, int idx){
        for(int i = 0; i < matrix[0].length; i ++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }    
    
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
    
    private int[] nextSmallestOfLeft(int[] heights, int n){
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
    
    private int[] nextSmallestOfRight(int[] heights, int n){
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
    }
}