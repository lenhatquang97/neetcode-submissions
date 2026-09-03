class Solution {
    class Pair {
        int left;
        int right;
        Pair (int a, int b) {
            left = a;
            right = b;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pr = (Pair) o;
            return left == pr.left && right == pr.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
    boolean res = false;
    HashMap<Pair, Boolean> queries = new HashMap<>();
    public boolean isWordBreak(String s, List<String> wordDict, int start, int end) {
        if (start == s.length()) {
            return true;
        }

        if (start >= end) {
            return false;
        }
        if (start == end && start < s.length()) 
            return wordDict.contains(s.substring(start, start + 1));
        if (start == end && s.length() != 1) return true;
        Pair key = new Pair(start, end);
        if (queries.containsKey(key))
            return queries.get(key);
        String word = s.substring(start, end);
        if (wordDict.contains(word)) {
            res = res || isWordBreak(s, wordDict, end, s.length());
        }
        if (!res) {
            res = res || isWordBreak(s, wordDict, start, end - 1);
        }
        queries.put(key, res);
        return res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return isWordBreak(s, wordDict, 0, s.length());
    }
}
