// leetcode 442
// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    class TrieNode {
        public HashMap<Character, TrieNode> char2child = new HashMap<>();
        public boolean isWord = false;
        public String word = null;
    }
    
    public TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.char2child.containsKey(letter)) {
                node.char2child.put(letter, new TrieNode());
            }
            node = node.char2child.get(letter);
        }
        node.isWord = true;
        node.word = word;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.char2child.containsKey(letter)) {
                return false;
            }
            node = node.char2child.get(letter);
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!node.char2child.containsKey(letter)) {
                return false;
            }
            node = node.char2child.get(letter);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
