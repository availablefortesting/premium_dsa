class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n - 1;
        
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            sb.append(s.charAt(i));
            i--;
        }
        
        System.out.println(sb.toString());
        return sb.length();
    }
}