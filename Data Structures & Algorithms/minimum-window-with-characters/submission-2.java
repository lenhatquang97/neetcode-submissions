class Solution {
    HashMap<Character, Integer> hm1 = new HashMap<>();
    HashMap<Character, Integer> hm2 = new HashMap<>();
    public boolean isValid() {
        for (Character key: hm2.keySet()) {
            if (!hm1.containsKey(key) || (hm1.get(key) < hm2.get(key))) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }

        int l = 0;
        int r = s.length() - 1;
        String res = "";
        int times = 0;
        while (l <= r) {
            if (isValid()) {
                char ch = s.charAt(r);
                hm1.put(ch, hm1.getOrDefault(ch, 1) - 1);
                res = s.substring(l, r + 1);
                r--;
            } else if (r == s.length() - 1 && times == 0) {
                return "";
            } else {
                char chL = s.charAt(l);
                if (l < s.length() - 1) l++;
                if (r < s.length() - 1) r++;
                char chR = s.charAt(r);
                hm1.put(chL, hm1.getOrDefault(chL, 1) - 1);
                hm1.put(chR, hm1.getOrDefault(chR, 0) + 1);
            }
            times++;
            if (r == s.length() - 1 && l == s.length() - 1) {
                if (isValid()) {
                    res = s.substring(l, r + 1);
                }
                return res;
            }
        }

        return res;
    }
}
