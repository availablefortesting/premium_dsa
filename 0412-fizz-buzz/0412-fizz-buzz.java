class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = i % 3 == 0 ? true : false;
            boolean divisibleBy5 = i % 5 == 0 ? true : false;
            
            if (divisibleBy3 && divisibleBy5) {
                res.add("FizzBuzz");
            } else if (divisibleBy3) {
                res.add("Fizz");
            } else if (divisibleBy5) {
                res.add("Buzz");
            } else {
                res.add(""+i);
            }
        }
        
        return res;
    }
}