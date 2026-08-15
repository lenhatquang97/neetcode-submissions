class Solution {
    public boolean isSamePermutation(String s1, String s2) {
        Map<Character, Integer> h1 = new TreeMap<>();
        Map<Character, Integer> h2 = new TreeMap<>();
        for (int i = 0; i < s1.length(); i++) {
            h1.put(s1.charAt(i), h1.getOrDefault(s1.charAt(i), 0) + 1);
            h2.put(s2.charAt(i), h2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        
        if (h1.size() != h2.size()) return false;
        for (Character ch : h1.keySet()) {
            if (!h2.containsKey(ch)) return false;
            if (h1.get(ch) != h2.get(ch)) return false;
        }

        for (Character ch : h2.keySet()) {
            if (!h1.containsKey(ch)) return false;
            if (h1.get(ch) != h2.get(ch)) return false;
        }
        
        return true;


    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int a = i;
            int b = i + s1.length();
            if (isSamePermutation(s1, s2.substring(a, b))) return true;
        }
        return false;
    }
}
