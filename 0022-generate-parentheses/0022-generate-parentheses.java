class Solution {
    public List<String> dpSolution(int n) {
        /*
            f(0): ""
            f(1): "("f(0)")"
            f(2): "("f(0)")"f(1), "("f(1)")"
            f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"
So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
        */
        
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        
        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();
            
            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            
            lists.add(list);
        }
        
        return lists.get(lists.size() - 1);
    }
    
    public void backtracking(List<String> list, String cur_s, int open, int close, int n){
        
        if(cur_s.length() == n * 2){
            list.add(cur_s);
            return;
        }
        
        if (open < n)
            backtracking(list, cur_s+"(", open+1, close, n);
        
        if (close < open)
            backtracking(list, cur_s+")", open, close+1, n);
    }
    
    public List<String> generateParenthesis(int n) {
        /*
           Amazon - 18 | Google - 8 | Microsoft - 7 | Adobe - 6 | Yahoo - 4 | Bloomberg - 3 | TikTok - 3 | 
           Facebook - 2 | Apple - 2 | Yandex - 2 | ServiceNow - 2 | Tesla - 2 
        */
        return dpSolution(n);
        
        // List<String> res = new ArrayList<String>();
        // backtracking(res, "", 0, 0, n);
        // return res;
    }
}