
class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st=new Stack<>();
    }
    
     public void push(int vals) {
        long val = (long)vals;
        if(st.size() == 0){
            st.push(val);
            min = val;
        }else{
            if(val >= min)
                st.push(val);
            else{
                st.push(val + val - min); 
                min = val; 
            }
        }
    }
    public void pop() {
        long val = st.pop();
        if (val < min)  
          min = 2 * min - val;
         
    }
    
    public long top() {
        if(st.peek()<min)
            return min;
        else
            return st.peek();
          
    }
    
    public long getMin() {
        return min;
      }
}
