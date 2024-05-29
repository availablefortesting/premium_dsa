class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        
        while(sb.length() != 1) {
            // even
            if (sb.charAt(sb.length() - 1) == '0') {
                int idx = sb.lastIndexOf("1");
                
                steps += (sb.length() - idx - 1);
                sb.delete(idx + 1, sb.length());
            } else {
                steps += 1;
                    
                int i = sb.length() - 1;
                while (i >= 0 && sb.charAt(i) == '1')
                    sb.setCharAt(i--, '0');
                
                if (i != -1) sb.setCharAt(i, '1');
                else    sb.insert(0, '1');
            }
            System.out.println(sb.toString());
        }
        
        return steps;
    }
}