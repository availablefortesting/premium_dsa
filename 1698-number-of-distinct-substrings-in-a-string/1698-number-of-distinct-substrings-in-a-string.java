public class Node {
    Node[] children = new Node[26];
}

class Solution {
    public int countDistinct(String s) {
        /*
            ServiceNow - 3
        */
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            
            for (int j = i; j < s.length(); j++) {
                int cur_char_index = s.charAt(j) - 'a';
                if (cur.children[cur_char_index] == null) {
                    cur.children[cur_char_index] = new Node();
                    res++;
                }
                cur = cur.children[cur_char_index];
            }
        }
        return res;
    }
}