class Solution {
    static boolean isOperator(char ch){
        if(ch == '^' || ch == '+' || ch == '-' || ch == '/' || ch == '*') return true;
        return false;
    }
    
    static String postToInfix(String exp) {
        // code here
        //step 1: start from left to right
         //step 2: when encountered a operator pull of the two operand from stack and concat the op1 + op + op2 enclosed in brackets
        //step 3: when the traversal is over return the top of stack
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(isOperator(ch)){
                String op1 = st.pop();
                String op2 = st.pop();
                
                String resultant = "("+op2+ch+op1+")";
                st.push(resultant);
            }else{
                String resultant = ch +"";
                st.push(resultant);
            }
        }
        
        return st.pop();
    }
}
