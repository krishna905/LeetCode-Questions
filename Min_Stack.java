/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

*/
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
