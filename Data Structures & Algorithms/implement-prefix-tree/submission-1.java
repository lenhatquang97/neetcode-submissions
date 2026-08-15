public class Trie {
    public Trie[] children;
    public boolean isEndOfWord;
    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }
}  

class PrefixTree {
    Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Trie();
            }

            if (i == word.length() - 1) {
                current.isEndOfWord = true;
            }
            
            current = current.children[c - 'a'];
        }
    }

    public boolean search(String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children[word.charAt(i) - 'a'] == null){
                return false;
            } else if (i == word.length() - 1) {
                return current.isEndOfWord;
            } else {
                current = current.children[word.charAt(i) - 'a'];
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.children[prefix.charAt(i) - 'a'] == null){
                return false;
            } else {
                current = current.children[prefix.charAt(i) - 'a'];
            }
        }
        return true;
    }
}
