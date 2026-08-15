class Solution {
    public int islandArea = 0;
    public void bfs(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length; 
        if (x >= m || y >= n || x < 0 || y < 0 || grid[x][y] == 0) return;
        grid[x][y] = 0;
        islandArea += 1;
        bfs(grid, x-1, y);
        bfs(grid, x+1, y);
        bfs(grid, x, y - 1);
        bfs(grid, x, y + 1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                    maxArea = Math.max(maxArea, islandArea);
                    islandArea = 0;
                } 
            }
        }
        return maxArea;
    }
}
