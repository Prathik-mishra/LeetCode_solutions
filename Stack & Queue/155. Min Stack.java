class MinStack {
    Stack<Long> st = new Stack<>();
    long min;
    public MinStack() {
        //if stack has any element before just remove the elements till it gets empty just for               safety purpose.
        while(st.isEmpty() == false) st.pop();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        long value = val;
        //if stack is empty just push the element and update the min val.
        if(st.isEmpty()){  
            st.push(value);
            min = value;
        }else{
            //if the val is lower the curr min insert a modified value in stack by using the                     formula "2*val-min". this is the trick to maintain the stack.
            if(value < min){ 
                st.push(2*value-min);  
                min = value;   
            //if the element is bigger just push   
            }else{          
                st.push(value);                
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long value = st.pop();
        //if the val is less the min that means it was a modified value so to get the previous min we use the formula "2*min-val" so that we restore the min to its previous min value.
        if(value < min){
            min = 2*min-value;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long value = st.peek();
        //if the top ele is less than min that means min is our curr top.
        if(value < min) return (int)min; 
        return (int)value;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
