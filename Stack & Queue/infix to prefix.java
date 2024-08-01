class Solution {
    // Function to convert an infix expression to a postfix expression.
    private static String reverse(String s){
      StringBuilder sb = new StringBuilder();
      for(int i=s.length()-1; i>=0; i--){
        sb.append(s.charAt(i));
      }
      return sb.toString();
    }

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
    public static String infixToPrefix(String exp) {
        // Your code here
        //step 1 : reverse the infix string and (brackets in opposite direction) 
        //step 2 : infix to postfix
        //step 3 : reverse the answer
        String exp = reverse(exp);
      
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
                if(ch == '^'){
                   while(!st.isEmpty() && precedence(ch) < precedence(st.peek())){
                    sb.append(st.pop());
                  }
                }else{
                  while(!st.isEmpty() && precedence(ch) <= precedence(st.peek())){
                    sb.append(st.pop());
                  } 
                }
                st.push(ch);
            }
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String answer = reverse(sb.toString());
        return answer;
    }
}
