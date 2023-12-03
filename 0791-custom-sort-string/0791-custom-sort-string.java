class Solution {
    public String customSortString(String order, String s) {
        char[] order_c = order.toCharArray();
        char[] s_c = s.toCharArray();
        
        HashMap<Character, Integer> cnts = new HashMap<>();
        for (char c : order_c) {
            cnts.put(c, 0);
        }
        List<Integer> indexes = new ArrayList<>();
        
        for (int i = 0; i < s_c.length; i++) {
            if (cnts.containsKey(s_c[i])) {
                cnts.put(s_c[i], 1 + cnts.get(s_c[i]));
                indexes.add(i);
            }
        }
        
        int i = -1;
        for (char c : order_c) {
            int pos_to_replace = cnts.get(c);
            while (pos_to_replace != 0) {
                s_c[indexes.get(++i)] = c;
                pos_to_replace--;
            }
        }

        return String.copyValueOf(s_c);
    }
}