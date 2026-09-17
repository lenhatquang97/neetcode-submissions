class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        int l = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch)
                    && window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {
                // Update answer
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                // Remove left character
                char leftChar = s.charAt(l);

                if (need.containsKey(leftChar)
                        && window.get(leftChar).intValue()
                            == need.get(leftChar).intValue()) {
                    formed--;
                }

                window.put(leftChar, window.get(leftChar) - 1);
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}