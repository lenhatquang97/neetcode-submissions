class Solution {
    Map<Character, ArrayList<Character>> mp = new HashMap<>();
    Map<Character, Integer> inDegreeLs = new HashMap<>();

    public List<char[]> retrieveTheComparison(String s1, String s2) {
        List<char[]> res = new ArrayList<>();

        int minSize = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minSize; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res.add(new char[]{
                    s1.charAt(i),
                    s2.charAt(i)
                });

                // Only first different character matters
                break;
            }
        }

        return res;
    }

    boolean hasCharInCharLs(ArrayList<Character> chLs, char ch) {
        for (int i = 0; i < chLs.size(); i++) {
            if (chLs.get(i) == ch) {
                return true;
            }
        }
        return false;
    }

    void init(String[] words) {
        mp.clear();
        inDegreeLs.clear();

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);

                mp.putIfAbsent(ch, new ArrayList<>());
                inDegreeLs.putIfAbsent(ch, 0);
            }
        }
    }

    public String foreignDictionary(String[] words) {
        Queue<Character> q = new LinkedList<>();
        List<Character> res = new ArrayList<>();

        init(words);

        // 1. Build graph
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // IMPORTANT:
            // ["abc", "ab"] is impossible
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            List<char[]> comparisons =
                retrieveTheComparison(s1, s2);

            for (char[] chars : comparisons) {
                char u = chars[0];
                char v = chars[1];

                ArrayList<Character> neighbors = mp.get(u);

                // Avoid duplicate edges
                if (!hasCharInCharLs(neighbors, v)) {
                    neighbors.add(v);
                }
            }
        }

        // 2. Calculate indegrees
        for (Character u : mp.keySet()) {
            for (Character v : mp.get(u)) {
                inDegreeLs.put(
                    v,
                    inDegreeLs.get(v) + 1
                );
            }
        }

        // 3. Add nodes with indegree 0
        for (Character ch : mp.keySet()) {
            if (inDegreeLs.get(ch) == 0) {
                q.add(ch);
            }
        }

        // 4. Kahn's topological sort
        while (!q.isEmpty()) {
            char u = q.poll();
            res.add(u);

            for (Character v : mp.get(u)) {
                inDegreeLs.put(
                    v,
                    inDegreeLs.get(v) - 1
                );

                if (inDegreeLs.get(v) == 0) {
                    q.add(v);
                }
            }
        }

        // 5. Cycle detection
        if (res.size() != inDegreeLs.size()) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (Character ch : res) {
            ans.append(ch);
        }

        return ans.toString();
    }
}