class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<List<String>>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());

        for (int end = 0; end <= n; end++) {
            for (int begin = 0; begin < end; begin++) {
                String candidate = s.substring(begin, end);

                if (isPalindrome(candidate)) {
                    for (List<String> each : dp.get(begin)) {
                        List<String> partition = new ArrayList<>(each);
                        partition.add(candidate);
                        dp.get(end).add(partition);
                    }
                }
            }
        }

        return dp.get(n);
    }
            
    public boolean isPalindrome(String s){
        int low = 0, high = s.length() - 1;
        while(low < high)
          if (s.charAt(low++) != s.charAt(high--)) 
              return false;
        return true;
    }
}
/*
[[[]], [['a']], [['aa'], ['a', 'a']], [['aa', 'b'], ['a', 'a', 'b']]]
[[[]], [['a']]]
*/