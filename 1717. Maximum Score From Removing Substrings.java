class Solution {
    private int getScoreOfRemovedSubString(String s,Stack<Character> st,String pattern,int points){
        int first = pattern.charAt(0);
        int second = pattern.charAt(1);
        int count = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == second && !st.isEmpty() && st.peek() == first){
                st.pop();
                count++;
            }else{
                st.push(ch);
            }
        }
        
        return count * points;
    }
    private String getNewString(Stack<Character> st){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        int priority = (x >= y) ? x : y;
        int a,b;
        if(priority == x){
            a = getScoreOfRemovedSubString(s,st,"ab",x);
            String newS = getNewString(st);
            s = newS;
            b = getScoreOfRemovedSubString(s,new Stack<Character>(),"ba",y);
        }else{
            a = getScoreOfRemovedSubString(s,st,"ba",y);
            String newS = getNewString(st);
            s = newS;
            b = getScoreOfRemovedSubString(s,new Stack<Character>(),"ab",x);
        }
        return a+b;
    }
}
