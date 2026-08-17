class Solution {
        ArrayList<Integer> parents = new ArrayList<>();
    ArrayList<Integer> ranks = new ArrayList<>();

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            parents.add(i);
            ranks.add(0);
        }
    }

    public int findParent(int v) {
        if (parents.get(v) != v) {
            parents.set(v, findParent(parents.get(v)));
        }
        return parents.get(v); 
    }

    public boolean isUnion(int u, int v){
        int rootU = findParent(u);
        int rootV = findParent(v);
        System.out.println(u + " has parent: " + rootU + " with rank " + ranks.get(rootU));
        System.out.println(v + " has parent: " + rootV + " with rank " + ranks.get(rootV));
        System.out.println();
        if (rootU != rootV) {
            if (ranks.get(rootU) > ranks.get(rootV)) {
                parents.set(rootV, rootU);
            } else if (ranks.get(rootU) < ranks.get(rootV)) {
                parents.set(rootU, rootV);
            } else {
                parents.set(rootV, rootU);
                ranks.set(rootU, ranks.get(rootU) + 1);
            }
            return true;
        }  
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) return true;

        Set<Integer> setPar = new HashSet<>();
        init(n);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (!isUnion(u, v)) {
                return false;
            }
        }
        for (int i = 0; i < parents.size(); i++) {
            int rootParent = findParent(parents.get(i));
            setPar.add(rootParent);
        }
        return setPar.size() == 1;
    }
}
