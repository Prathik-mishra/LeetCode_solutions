class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        StringBuilder str = new StringBuilder();
        
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            
            if(c == '('){
                if(st.isEmpty()){
                   st.push(c); 
                }else{
                    st.push(c);
                    str.append(c);
                }    
            }else{
                if(st.size() == 1){
                    st.pop();
                }else{
                    str.append(c);
                    st.pop();
                }
            }
        }
        return str.toString();
    }
}
