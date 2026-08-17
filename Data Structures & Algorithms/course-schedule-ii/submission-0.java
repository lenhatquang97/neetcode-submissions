class Solution {
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    ArrayList<Integer> inDegreeLs = new ArrayList<>();
    public void addEdges(int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList.get(v).add(u);
        }
    }
    public void initCourses(int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            inDegreeLs.add(0);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        initCourses(numCourses);
        addEdges(prerequisites);

        for (int i = 0; i < numCourses; i++) {
            for (int next : adjList.get(i)) {
                inDegreeLs.set(next, inDegreeLs.get(next) + 1);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegreeLs.get(i) == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer tmp = q.poll();
            res.add(tmp);
            for (int next : adjList.get(tmp)) {
                inDegreeLs.set(next, inDegreeLs.get(next) - 1);
                if (inDegreeLs.get(next) == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 0; i < inDegreeLs.size(); i++) {
            if (inDegreeLs.get(i) < 0 || inDegreeLs.get(i) > 0) return new int[]{};
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
