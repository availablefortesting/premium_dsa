// class Node {
//     TreeMap<Character, Node> childrens;
//     boolean isWord;
    
//     public Node() {
//         this.childrens = new TreeMap<>();
//         this.isWord = false;
//     }
// }

// class Trie {
//     Node root;
//     Node cur_pointer;
//     int suggestion_cnt;
//     static int cnt;
    
//     public Trie(int suggestion_cnt) {
//         this.root = new Node();
//         this.suggestion_cnt = suggestion_cnt;
//     }
    
//     public void insert (String word) {
//         Node cur = this.root;
//         for (char c : word.toCharArray()) {
//             if (!cur.childrens.containsKey(c)) {
//                 cur.childrens.put(c, new Node());
//             }
//             cur = cur.childrens.get(c);
//         }
//         cur.isWord = true;
//     }
    
//     public List<String> getSuggestions(char c, boolean isNewSearchWord) {
//         if (cur_pointer == null || isNewSearchWord)
//             cur_pointer = this.root;
        
//         List<String> suggestions = new ArrayList<>();
//         Trie.cnt = this.suggestion_cnt;
//         dfs(cur_pointer, "", suggestions);
        
//         return suggestions;
//     }
    
//     private Node getNode(char c) {
//         Node cur = this.root;
//         return cur;
//     }
    
//     private void dfs(Node node, String cur_word, List<String> suggestions) {
//         if (node == null)   return;
        
//         if (node.isWord) {
//             suggestions.add(cur_word);
//             cnt--;
//         }
        
//         if (cnt == 0)   return;
            
//         for (Map.Entry<Character,Node> entry : node.childrens.entrySet()) {
//             dfs(entry.getValue(), cur_word + entry.getKey(), suggestions);
//         }
//     }
// }

class Solution {
    class Trie {
        Trie[] sub = new Trie[26];
        LinkedList<String> suggestion = new LinkedList<>();
    }

    public void insert(String p, Trie root) {
        Trie t = root;
        for (char c : p.toCharArray()) { // insert current product into Trie.
            if (t.sub[c - 'a'] == null)
                t.sub[c - 'a'] = new Trie();
            t = t.sub[c - 'a'];

            addToSuggestions(t.suggestion, p);
            // t.suggestion.offer(p); // put products with same prefix into suggestion list.
            // Collections.sort(t.suggestion);
            // if (t.suggestion.size() > 3) // maintain 3 lexicographically minimum strings.
            //     t.suggestion.pollLast();        
        }
    }

    private void addToSuggestions(LinkedList<String> suggestions, String p) {
        int i;
        for (i = 0; i < suggestions.size(); i++)
            if (suggestions.get(i).compareTo(p) >= 0)
                break;

        suggestions.add(i, p);
        if (suggestions.size() > 3)
            suggestions.pollLast();
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String p : products)   insert(p, root);
        
        return search(searchWord, root);
    }
    
    private List<List<String>> search(String searchWord, Trie root) {
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()) { 
            if (root != null)
                root = root.sub[c - 'a'];
            ans.add(root == null ? Arrays.asList() : root.suggestion);
        }
        return ans;
    }
}