class Solution {
    int[][] locations = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.' || board[x][y] == 'X') return;
        board[x][y] = '.';
        for (int i = 0; i <= 3; i++) {
            dfs(board, x + locations[i][0], y + locations[i][1]);
        }
        
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }
        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }

        
    }
}
