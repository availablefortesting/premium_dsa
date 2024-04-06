class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] s_chars = s.toCharArray();
        
        for(int i = 0; i < s_chars.length; i++) {
            if(s_chars[i] == '(')
                stack.push(i);
            else if (s_chars[i] == ')') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else stack.push(i);
            }
        }
        
        if(stack.size() == 0) return s;
        
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            s_chars[idx] = '#';
        }
        
        return String.copyValueOf(s_chars).replace("#","");
    }
}