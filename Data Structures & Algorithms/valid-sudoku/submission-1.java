class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> hs1 = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && hs1.contains(((int)board[i][j]))) {
                    return false;
                } else if (board[i][j] != '.') {
                    hs1.add(((int)board[i][j]));
                }
            }
            hs1.clear();
        }

        HashSet<Integer> hs2 = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && hs2.contains(((int)board[i][j]))) {
                    return false;
                } else if (board[i][j] != '.') {
                    hs2.add(((int)board[i][j]));
                }
            }
            hs2.clear();
        }

        for (int step = 0; step <= 8; step = step + 3) {
            HashSet<Integer> hs3 = new HashSet<>();
            for (int i = step; i <= step + 2; i++) {
                for (int j = 0; j <= 2; j++) {
                if (board[i][j] != '.' && hs3.contains(((int)board[i][j]))) {
                    return false;
                } else if (board[i][j] != '.') {
                    hs3.add(((int)board[i][j]));
                }
                }
            }
            hs3.clear();

            for (int i = step; i <= step + 2; i++) {
                for (int j = 3; j <= 5; j++) {
                    if (board[i][j] != '.' && hs3.contains(((int)board[i][j]))) {
                    return false;
                } else if (board[i][j] != '.') {
                    hs3.add(((int)board[i][j]));
                }

                }
            }
            hs3.clear();

            for (int i = step; i <= step + 2; i++) {
                for (int j = 6; j <= 8; j++) {
if (board[i][j] != '.' && hs3.contains(((int)board[i][j]))) {
                    return false;
                } else if (board[i][j] != '.') {
                    hs3.add(((int)board[i][j]));
                }
                }
            }
            hs3.clear();

        }

        

        

        return true;
    }
}
