class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == 0 || len == 0) return num;
        if(len == k) return "0";
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        while(i < len){
            //if the element before the current ele is greater the pop it out 
            
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        //for the edge case where my i may get exhaused before k like num=1111 and k = 2:
        while(k != 0){
            stack.pop();
            k--;
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head   edge case
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();        
    }
}
