class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for(int i=0; i<logs.length; i++){
            String operation = logs[i];
            if(operation.equals("./")){
                continue;
            }else if(operation.equals("../")){
                if(!st.isEmpty()){
                    st.pop();   
                }
            }else{
                st.push(operation);
            }
        }
        
        return st.size();
    }
}
