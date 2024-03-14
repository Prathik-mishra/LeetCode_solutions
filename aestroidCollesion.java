class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : asteroids){
            //this means it is moving in right direction so push it in stack
            if(i > 0){ 
                stack.push(i);
            }else{  // i is negative
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(i)){
                    stack.pop();
                }
                
                if(stack.isEmpty() || stack.peek() < 0){   // stack is empty and 
                    stack.push(i);
                }else if(i + stack.peek() == 0){  // if the elements are same poping the peek out
                    stack.pop();
                }
            }
        }
        //transfering all the elements from stack to answer array:
        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1 ; !stack.isEmpty() ; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
