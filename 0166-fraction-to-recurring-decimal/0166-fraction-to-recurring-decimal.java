class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        /*
            Goldman Sachs - 3 | ServiceNow - 2
        */
        
    // EDGE : case
        if (numerator == 0)
            return "0";
        else if (denominator == 0)
            return "Infinity";
        
        StringBuilder res = new StringBuilder();
        
    // check sign
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        
    // perform integer part 
        long nume = Math.abs((long) numerator);     // EDGE : long because for big fraction part int will overflow
        long deno = Math.abs((long) denominator);
        
        res.append(nume / deno);
        
        nume %= deno;
        if (nume == 0)
            return res.toString();
        
    // perform fraction part
        res.append(".");
        HashMap<Long,Integer> m = new HashMap<>();
        m.put(nume, res.length());
        while (nume != 0) {
            nume *= 10;
            res.append(nume / deno);
            nume %= deno;
            
            if (m.containsKey(nume)) {
                int idx = m.get(nume);
                res.insert(idx, "(");
                res.append(")");
                break;
            } else {
                m.put(nume, res.length());
            }
        }
        
        return res.toString();
        
    }
}