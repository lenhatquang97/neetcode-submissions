class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Pair)) return false;

        Pair other = (Pair) obj;

        return first == other.first &&
               second == other.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

class Solution {
    int[][] locations = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    List<List<Integer>> res = new ArrayList<>();
    Set<Pair> visited = new HashSet<>();
    boolean flagPacific = false;
    boolean flagAtlantic = false;

    public boolean isPacific(int[][] heights, int x, int y) {
        return x == 0 || y == 0;
    }
    public boolean isAtlantic(int[][] heights, int x, int y) {
        return x == heights.length - 1 || y == heights[0].length - 1;
    }


    public void dfs(int[][] heights, int x, int y, int prevHeight) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) return;
        if (prevHeight != -1 && prevHeight < heights[x][y]) return;
        if (visited.contains(new Pair(x, y))) return;
        if (flagPacific && flagAtlantic) return;
        visited.add(new Pair(x, y));
        flagPacific = flagPacific || isPacific(heights, x, y);
        flagAtlantic = flagAtlantic || isAtlantic(heights, x, y);
        if (x == 0 && y == 2) {
            System.out.println("GG " + flagPacific + " and " + flagAtlantic);
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + locations[i][0];
            int newY = y + locations[i][1];
            dfs(heights, newX, newY, heights[x][y]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 && j == heights[0].length - 1) {
                    res.add(new ArrayList<>(List.of(i, j)));
                } else if (i == heights.length - 1 && j == 0) {
                    res.add(new ArrayList<>(List.of(i, j)));
                } else {
                    System.out.println("Start");
                    if (i == 0 && j == 2) {
                        System.out.println("Bye");
                    }
                    dfs(heights, i, j, -1);
                    if (flagPacific && flagAtlantic) {
                        res.add(new ArrayList<>(List.of(i, j)));
                    }

                    for (Pair p : visited) {
                        System.out.print(p.first + " " + p.second + " - ");
                    }
                    System.out.println();
                    flagPacific = false;
                    flagAtlantic = false;
                    visited.clear();
                    System.out.println("End");
                }
            }
        }
        return res;
    }
}
