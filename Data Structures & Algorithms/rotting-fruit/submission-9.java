class Pair {
    public int first;
    public int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int fresh = 0;
    int res = 0;
    int[] arr1 = {0, 0, 1, -1};
    int[] arr2 = {1, -1, 0, 0};
    public boolean isPointValid(int[][] grid, Pair point, int loc) {
        int x = point.first + arr1[loc];
        int y = point.second + arr2[loc];
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
    public void bfs(int[][] grid, Queue<Pair> q) {
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int u = 0; u < size; u++) {
                Pair queueVal = q.poll();
                for (int i = 0; i <= 3; i++) {
                    int x = queueVal.first + arr1[i];
                    int y = queueVal.second + arr2[i];
                    if (isPointValid(grid, queueVal, i)) {    
                        grid[x][y] = 2;
                        q.add(new Pair(x, y));
                        fresh--;
                    }
                }
            }
            res += 1;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        bfs(grid, q);
        return fresh == 0 ? res : -1;
    }
}
