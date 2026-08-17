class Solution {
    Map<Character, ArrayList<Character>> mp = new HashMap<>();
    Map<Character, Integer> inDegreeLs = new HashMap<>();
    public List<char[]> retrieveTheComparison(String s1, String s2) {
        List<char[]> res = new ArrayList<>();
        if (s1.startsWith(s2))
            return res;

        int minSize = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minSize; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res.add(new char[] {s1.charAt(i), s2.charAt(i)});
                break;
            }
        }
        return res;
    }

    boolean hasCharInCharLs(ArrayList<Character> chLs, char ch) {
        for (int i = 0; i < chLs.size(); i++) {
            if (chLs.get(i) == ch)
                return true;
        }
        return false;
    }

    void init(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                mp.put(ch, new ArrayList<>());
                inDegreeLs.put(ch, 0);
            }
        }
    }

    public String foreignDictionary(String[] words) {
        Queue<Character> q = new LinkedList<>();
        List<Character> res = new ArrayList<>();
        init(words);
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // Fix: invalid prefix case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

            List<char[]> tmp = retrieveTheComparison(s1, s2);

            for (char[] chLs : tmp) {
                char u = chLs[0];
                char v = chLs[1];
                ArrayList<Character> tmpCharList = mp.getOrDefault(u, new ArrayList<>());

                if (!hasCharInCharLs(tmpCharList, v)) {
                    tmpCharList.add(v);
                    mp.put(u, tmpCharList);
                }
            }
        }

        for (Character chKey : mp.keySet()) {
            for (Character next : mp.get(chKey)) {
                System.out.println(chKey + " -> " + next);
            }
        }

        for (Character chKey : mp.keySet()) {
            for (Character next : mp.get(chKey)) {
                inDegreeLs.put(next, inDegreeLs.get(next) + 1);
            }
        }

        for (Character chKey : mp.keySet()) {
            if (inDegreeLs.get(chKey) == null || inDegreeLs.get(chKey) == 0) {
                q.add(chKey);
            }
        }

        while (!q.isEmpty()) {
            Character tmp = q.poll();
            res.add(tmp);
            if (mp.get(tmp) == null)
                continue;
            for (Character next : mp.get(tmp)) {
                inDegreeLs.put(next, inDegreeLs.getOrDefault(next, 0) - 1);
                if (inDegreeLs.getOrDefault(next, 0) == 0) {
                    q.add(next);
                }
            }
        }

        String finalAns = "";
        for (Character ch : res) {
            finalAns += ch;
        }
        return finalAns.length() != inDegreeLs.size() ? "" : finalAns;
    }
}