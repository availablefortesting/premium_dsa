public class Node {
    Node[] links;
    
    Node () {
        links = new Node[26];
    }
    
    public void put(char c, Node node) {
        links[c - 'a'] = node;
    }
    public Node get(char c) {
        return links[c - 'a'];
    }
}

class Solution {
    public int countDistinct(String s) {
        /*
            ServiceNow - 3
        */
        int cnt = 0;
        Node root = new Node();
        
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            
            for (int j = i; j < s.length(); j++) {
                if (cur.get(s.charAt(j)) == null) {
                    cnt++;
                    cur.put(s.charAt(j), new Node());
                }
                cur = cur.get(s.charAt(j));
            }
        }
        
        return cnt;
    }
}