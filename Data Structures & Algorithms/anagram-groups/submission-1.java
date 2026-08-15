class Solution {
    public String calculateKey(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i =0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
        }
        int hmSize = hm.size();
        String res = "";
        for (char ch: hm.keySet()) {
            res +=  ch;
            res += hm.get(ch);
        }
        return res;
    }



    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (int i=0; i < strs.length; i++) {
            String key = calculateKey(strs[i]);
            if (mp.containsKey(key)) {
                List<String> ls = mp.get(key);
                ArrayList<String> arr = new ArrayList<>(ls);
                arr.add(strs[i]);
                mp.put(key, arr);
            } else {
                mp.put(key, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        for (String k: mp.keySet()) {
            res.add(mp.get(k));
        }

        return res;
    }
}
