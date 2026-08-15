class Solution {
    public int countSubstrings(String s) {
        int[][] res = new int[s.length()][s.length()];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = 1;
            cnt += 1;
        }
        for (int l = 1; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && res[i+1][j-1] == j - i - 1) {
                    res[i][j] = res[i+1][j-1] + 2;
                    cnt += 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return cnt;
    }
}
