class Solution {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    TrieNode trie = new TrieNode();

    // Function to replace words
    private int replaceWord(String word) {
        TrieNode cur = this.trie;
        
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (cur.children.get(letter) == null)   break;
            
            cur = cur.children.get(letter);
            if (cur.children.containsKey('#'))  return i + 1;
        }
        return word.length();
    }
    
    public String replaceWords(List<String> roots, String sentence) {
        // Build the trie
        for (String root : roots) {
            TrieNode cur = this.trie;
            for (char letter : root.toCharArray()) {
                if (cur.children.containsKey('#')) break;
                cur = cur.children.computeIfAbsent(letter, k -> new TrieNode());
            }
            cur.children.put('#', null); // Mark the end of the word
        }

        // Split sentence into words and replace them
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (result.length() > 0) result.append(" ");
            result.append(word.substring(0, replaceWord(word)));
        }

        return result.toString();
    }
}