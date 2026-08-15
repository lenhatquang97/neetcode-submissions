public class Trie {
    public Trie[] children;
    public boolean isEndOfWord;
    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }
}

class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Trie();
            }
            current = current.children[c - 'a'];
        }
        current.isEndOfWord = true;
    }
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Trie root) {
        Trie current = root;
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (Trie child : current.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (current.children[word.charAt(i) - 'a'] == null){
                    return false;
                } 
                current = current.children[word.charAt(i) - 'a'];
            }
        }
        return current.isEndOfWord;
    }
}
