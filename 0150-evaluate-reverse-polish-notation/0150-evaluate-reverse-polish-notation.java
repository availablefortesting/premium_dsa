class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (String token : tokens) {
            if ("+".equals(token)) 
                st.push(st.pop() + st.pop());
            else if ("-".equals(token)) 
                st.push(-st.pop() + st.pop());
            else if ("*".equals(token)) 
                st.push(st.pop() * st.pop());
            else if ("/".equals(token)) {
                int denominator = st.pop();
                st.push(st.pop() / denominator);
            } else
                st.push(Integer.valueOf(token));
        }
        
        return st.pop();
    }
}