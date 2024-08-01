class Solution {
    // Function to convert an infix expression to a postfix expression.
    private static int precedence(char ch){
        if(ch == '^'){
            return 3;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }else{
            return 0;
        }
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(Character.isLetter(ch) || Character.isDigit(ch)){
                sb.append(ch);
            }else if(ch == '('){
                st.push(ch);
            }else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            }else{
                while(!st.isEmpty() && precedence(ch) <= precedence(st.peek()) && st.peek() != '('){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
}
