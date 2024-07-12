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
        /*
        // approach 1 : using stack
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
        */
        
        //approach 2 : optimised greedy counting
        if(x >= y){
            return getMaxScore(s,x,y,"ab");
        }else{
            return getMaxScore(s,y,x,"ba");
        }
    }
    
    private int getMaxScore(String s, int x, int y, String pattern){
        int firstCount = 0, secondCount = 0,totalScore = 0;
        char first = pattern.charAt(0);
        char second = pattern.charAt(1);
        
        for(char ch : s.toCharArray()){
            if(ch == first){
                firstCount++;
            }else if(ch == second){
                if(firstCount > 0){
                    firstCount--;
                    totalScore += x;
                }else{
                    secondCount++;
                }
            }else{
                totalScore += (Math.min(firstCount,secondCount) * y);
                firstCount = secondCount = 0;
            }
        }
        totalScore += (Math.min(firstCount,secondCount) * y);
        return totalScore;
    }
}
