class Solution {
    static boolean isOperator(char ch){
        if(ch == '^' || ch == '+' || ch == '-' || ch == '/' || ch == '*') return true;
        return false;
    }
    
    static String preToInfix(String pre_exp) {
        // code here
        //step 1: start from right to left(in reverse fashion)
        //step 2: when encountered a operator pull of the two operand from stack and concat the op1 + op + op2 enclosed in brackets
        //when the traversal is over return the top of stack 
        
        Stack<String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1; i>=0; i--){
            char ch = pre_exp.charAt(i);
            
            if(isOperator(ch)){
                String op1 = st.pop();
                String op2 = st.pop();
                
                String resultant = "("+op1+ch+op2+")";
                st.push(resultant);
            }else{
                String resultant = ch +"";
                st.push(resultant);
            }
        }
        
        return st.pop();
    }
}
