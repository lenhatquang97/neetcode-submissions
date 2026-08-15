class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int right = 1;
        hs.add(s.charAt(left));
        int maxLength = 0;
        while (left < s.length() && right < s.length()) {
            while (left < right && hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            } 
            hs.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
