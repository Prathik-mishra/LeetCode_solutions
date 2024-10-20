class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = expression.charAt(i);

            if(ch == ','){
                continue;
            }else if(ch == ')'){
                int tCount = 0;
                int fCount = 0;
                while(st.peek() != '('){
                    char currCh = st.pop();
                    if(currCh == 't'){
                        tCount++;
                    }else{
                        fCount++;
                    }
                }
                st.pop();
                char currOp = st.pop();

                st.push(eval(currOp,tCount,fCount));
            }else{
                st.push(ch);
            }
        }

        return st.peek() == 't' ? true : false;
    }

    private char eval(char currOp, int tCount, int fCount){
        if(currOp == '&'){
            if(fCount >= 1){
                return 'f';
            }else{
                return 't';
            }
        }else if(currOp == '|'){
            if(tCount >= 1){
                return 't';
            }else{
                return 'f';
            }
        }else{
            if(fCount >= 1){
                return 't';
            }else{
                return 'f';
            }
        }
    }
}
