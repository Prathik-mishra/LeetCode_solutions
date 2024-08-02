class Solution {
    static boolean isOperator(char c){
        if(c == '^' || c == '+' || c == '-' || c == '/' || c == '*') return true;
        return false;
    }
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1; i>=0; i--){
            char ch = pre_exp.charAt(i);
            
            if(isOperator(ch)){
                String op1 = st.pop();
                String op2 = st.pop();
                
                String resultant = op1+op2+ch;
                st.push(resultant);
            }else{
                st.push(ch+"");
            }
        }
        
        return st.peek();
    }
}
