class Solution {
    public void bfs(int[][] grid, int x, int y, int dist) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1 || grid[x][y] < dist) return;
        grid[x][y] = dist;
        
        bfs(grid, x - 1, y, dist + 1);
        bfs(grid, x + 1, y, dist + 1);
        bfs(grid, x, y - 1, dist + 1);
        bfs(grid, x, y + 1, dist + 1);
    }
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, i, j, 0);
                }
            }
        }
    }
}