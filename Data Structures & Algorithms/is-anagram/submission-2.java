class Solution {
    public void addToHashMap(HashMap<Character, Integer> hm, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {
                hm.put(ch, 1);
            }
        }
    }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();
        addToHashMap(h1, s);
        addToHashMap(h2, t);

        if (h1.size() != h2.size()) return false;
        return h1.equals(h2);

    }
}
