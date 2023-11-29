class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);
            
            String temp = "";
            if (divisibleBy3) {
                temp += "Fizz";
            } 
            if (divisibleBy5) {
                temp += "Buzz";
            } 
             if ("".equals(temp)) {
                temp += i;
            }
            
            res.add(temp);
        }
        
        return res;
    }
}