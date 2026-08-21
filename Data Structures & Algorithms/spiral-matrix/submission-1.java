class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int minLength = Math.min(m, n);
        int threshold = minLength % 2 == 0 ? minLength / 2 - 1 : minLength / 2;
        while (i <= threshold) {
            if (i > n - 1 - i) return res;
            for (int v = i; v <= n - 1 - i; v++) {
                res.add(matrix[i][v]);
            }
            
            if (i + 1 > m - 1 - i) return res;
            for (int v = i + 1; v <= m - 1 - i; v++) {
                res.add(matrix[v][n - 1 - i]);
            }

            if (n - 2 - i < i) return res;
            for (int v = n - 2 - i; v >= i; v--) {
                System.out.println(matrix[m - 1 - i][v]);
                res.add(matrix[m - 1 - i][v]);
            }

            if (m - 2 - i < i + 1) return res;
            for (int v = m - 2 - i; v >= i + 1; v--) {
                res.add(matrix[v][i]);
            }
            i++;
        }
        return res;
    }
}
