class Solution {
    public String longestPalindrome(String s) {
        int[][] res = new int[s.length()][s.length()];
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = 1;
            maxStr = s.substring(i, i+1);
        }
        for (int l = 1; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j) && res[i+1][j-1] == j - i - 1) {
                    res[i][j] = res[i+1][j-1] + 2;
                    if (s.substring(i, j+1).length() > maxStr.length()) {
                        maxStr = s.substring(i, j+1);
                    }
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return maxStr; 
    }
}
