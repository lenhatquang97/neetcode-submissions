class Solution {
    public void rotate(int[][] matrix) {
        int u = 0;
        int v = matrix.length - 1;
        int n = matrix.length - 1;
        while (u < v) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[u][i];
                matrix[u][i] = matrix[v][i];
                matrix[v][i] = tmp;
            }
            u++;
            v--;
        }
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
