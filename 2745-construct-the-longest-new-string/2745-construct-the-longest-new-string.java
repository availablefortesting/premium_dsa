class Solution {
    public int longestString(int x, int y, int z) {
        String res = "";
        int min = Math.min(x,y);
        
        if (x > y)
            res = "AB".repeat(z) + "AABB".repeat(min) + "AA";
        else {
            res = "BBAA".repeat(min);
            if (x != y)
                res += "BB";
            res += "AB".repeat(z);
        }
        
        return res.length();
        // int res = (2 * Math.min(x,y) + z + 1) * 2;
        // return x == y ? res - 2 : res;  // subtract -1 (min + min)
    }
}