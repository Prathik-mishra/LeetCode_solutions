class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        int n = s.length();
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                while(st.peek() != '('){
                    queue.add(st.pop());
                }
                st.pop();
                while(!queue.isEmpty()){
                    st.push(queue.remove());
                }
            }else{
                st.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
