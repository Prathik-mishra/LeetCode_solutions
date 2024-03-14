import java.util.Stack;

public class ExpressionEvalvation {
    //function to reverse the string
    public static String reverse(String s){

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length-1;

        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        //reverse the bracks arrangements
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){
                arr[i] = ')';
            }else if(arr[i] == ')'){
                arr[i] = '(';
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }

        return sb.toString();

    }

    // function which will return precidence for a character(operator)
    public static int getPrecidence(char ch){

        if(ch == '^'){
            return 3;
        }else if(ch == '/' || ch == '*'){
            return 2;
        }else if(ch == '-' || ch == '+'){
            return 1;
        }else{
            return -1;
        }

    }

    public static String infixToPostfix(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
            }else if((ch >= 'a' && ch <= 'z' ) || (ch >= 'A' && ch <= 'Z') ){
                sb.append(ch);
            }else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.peek());
                    st.pop();
                }
                st.pop(); //the last bracket
            }else{
                while(!st.isEmpty() && getPrecidence(st.peek()) > getPrecidence(ch)){
                    sb.append(st.peek());
                    st.pop();
                }
                st.push(ch);
            }
        }

        // if there is any remaning operator in stack than pop and print it
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }

        return sb.toString();
    }

    public static String infixToPrefix(String str){
        StringBuilder sb = new StringBuilder();
        String s = reverse(str);
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
            }else if((ch >= 'a' && ch <= 'z' ) || (ch >= 'A' && ch <= 'Z') ){
                sb.append(ch);
            }else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.peek());
                    st.pop();
                }

                if(!st.isEmpty()){//the last bracket
                    st.pop();
                }
                
            }else{
                while(!st.isEmpty() && getPrecidence(st.peek()) > getPrecidence(ch)){
                    sb.append(st.peek());
                    st.pop();
                }
                st.push(ch);
            }
        }

        // if there is any remaning operator in stack than pop and print it
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }


        return reverse(sb.toString());
    }

    public static int postfixEvaluation(String s){
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                st.push(ch-'0');
            }else{
                int operent2 = (int) (st.peek());
                st.pop();
                int operent1 = (int) (st.peek());
                st.pop();

                switch(ch){
                    case '+':
                        st.push(operent1+operent2);
                        break;
                    case '-':
                        st.push(operent1-operent2);
                        break;
                    case '*':
                        st.push(operent1*operent2);
                        break;
                    case '/':
                        st.push(operent1/operent2);
                        break;
                    case '^':
                        st.push((int) Math.pow(operent1,operent2));
                        break;
                }
            }
        }
        return st.pop();
    }

    public static int prefixEvaluation(String s){
        
        Stack<Integer> st = new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                st.push(ch-'0');
            }else{
                int operent1 = (int) (st.peek());
                st.pop();
                int operent2 = (int) (st.peek());
                st.pop();

                switch(ch){
                    case '+':
                        st.push(operent1+operent2);
                        break;
                    case '-':
                        st.push(operent1-operent2);
                        break;
                    case '*':
                        st.push(operent1*operent2);
                        break;
                    case '/':
                        st.push(operent1/operent2);
                        break;
                    case '^':
                        st.push((int) Math.pow(operent1,operent2));
                        break;
                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        //example Test case:
        String exp = "(a-b/c)*(a/k-l)";

        // infixToPostfix function call
        System.out.println(infixToPostfix(exp));

        // infixToPrefix function call
        System.out.println(infixToPrefix(exp));

        //example Test Case:
        String exp2 = "46+2/5*7+";

        // Postfix evaluation function call
        System.out.println(postfixEvaluation(exp2));

        //example Test Case:
        String exp3 = "-+7*45+20";

        // Prefix evaluation function call
        System.out.println(prefixEvaluation(exp3));
    }
}
