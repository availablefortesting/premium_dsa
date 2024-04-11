class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k)  return "0";
        Stack<Character> st = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }
        
        while (k != 0) {
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    }
}