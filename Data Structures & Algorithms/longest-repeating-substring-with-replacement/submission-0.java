class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            int maxF = Collections.max(hm.values());
            while ((r - l + 1) - maxF > k) {
                hm.put(s.charAt(l), hm.getOrDefault(s.charAt(l), 1) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
