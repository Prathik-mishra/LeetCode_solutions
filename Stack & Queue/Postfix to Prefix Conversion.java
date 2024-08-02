class Solution {
    static boolean isOperator(char c){
        if(c == '^' || c == '+' || c == '-' || c == '/' || c == '*') return true;
        return false;
    }
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<post_exp.length(); i++){
            char ch = post_exp.charAt(i);
            
            if(isOperator(ch)){
                String op1 = st.pop();
                String op2 = st.pop();
                
                String resultant = ch+op2+op1;
                st.push(resultant);
            }else{
                st.push(ch+"");
            }
        }
        
        return st.peek();
    }
}
