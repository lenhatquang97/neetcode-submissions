class Solution {
    public HashMap<Integer, List<Character>> hm = new HashMap<>();
    public List<String> res = new ArrayList<>();

    public void initHashMap(HashMap<Integer, List<Character>> hm) {
        hm.put(2, Arrays.asList('a', 'b', 'c'));
        hm.put(3, Arrays.asList('d', 'e', 'f'));
        hm.put(4, Arrays.asList('g', 'h', 'i'));
        hm.put(5, Arrays.asList('j', 'k', 'l'));
        hm.put(6, Arrays.asList('m', 'n', 'o'));
        hm.put(7, Arrays.asList('p', 'q', 'r', 's'));
        hm.put(8, Arrays.asList('t', 'u', 'v'));
        hm.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public void backtrack(String digits, String currText, int index) {
        if (currText.length() == digits.length()) {
            res.add(currText);
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            List<Character> tmpLs = hm.get(digits.charAt(i) - '0');
            for (Character ch: tmpLs) {
                backtrack(digits, currText + ch, i + 1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        initHashMap(hm);
        backtrack(digits, "", 0);
        return res;
    }
}
