class Solution {
    public boolean isValid(String s) {
        // Stack<Character> st = new Stack<>();
        // for(int i = 0 ; i < s.length() ; i++){
        //     if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
        //         st.push(s.charAt(i));
        //     }else{
        //         if(st.isEmpty()) return false;
        //         char c = st.pop();
        //         if(s.charAt(i) == ')' && c == '(') continue;
        //         if(s.charAt(i) == ']' && c == '[') continue;
        //         if(s.charAt(i) == '}' && c == '{') continue;
        //         else return false;           
        //     }
        // }
        // return st.isEmpty();
        
        //approach 2 using for each
         Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop(); 
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
}
