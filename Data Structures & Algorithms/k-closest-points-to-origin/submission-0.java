class MaxHeap {
    private ArrayList<Pair<Integer, Integer>> heapArray = new ArrayList<>();
    private int kMax = -1;

    public MaxHeap(int k, int[][] points) {
        kMax = k;
        for (int i = 0; i < points.length; i++) {
            add(points[i][0], points[i][1]);
        }
    }

    private int parent(int key) {
        return (key - 1) / 2;
    }

    private int left(int key) {
        return 2 * key + 1;
    }

    private int right(int key) {
        return 2 * key + 2;
    }

    private void swap(int i, int j) {
        Pair<Integer, Integer> tmp = heapArray.get(i);
        heapArray.set(i, heapArray.get(j));
        heapArray.set(j, tmp);
    }

    private void insert(int a, int b) {
        heapArray.add(new Pair<>(a, b));

        int i = heapArray.size() - 1;

        while (i != 0 &&
            dist(heapArray.get(i)) > dist(heapArray.get(parent(i)))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public double dist(Pair<Integer, Integer> p) {
        return Math.sqrt(p.getKey() * p.getKey() + p.getValue() * p.getValue());
    }

    public double dist(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }

    private void insertToTopK(int a, int b) {
        if (heapArray.size() < kMax) {
            insert(a, b);
            return;
        }

        if (dist(a, b) < dist(heapArray.get(0))) {
            heapArray.set(0, new Pair(a, b));
            maxHeapify(0);
        }
    }

    public Pair<Integer, Integer> add(int a, int b) {
        insertToTopK(a, b);
        return heapArray.get(0);
    }


    private void maxHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < heapArray.size() && dist(heapArray.get(l)) > dist(heapArray.get(smallest))) {
            smallest = l;
        }
        if (r < heapArray.size() && dist(heapArray.get(r)) > dist(heapArray.get(smallest))) {
            smallest = r;
        }

        if (smallest != key) {
            swap(key, smallest);
            maxHeapify(smallest);
        }
    }

    public int[][] convertToArray() {
        int[][] arr = new int[heapArray.size()][2];
        for (int i = 0; i < heapArray.size(); i++) {
            arr[i][0] = heapArray.get(i).getKey();
            arr[i][1] = heapArray.get(i).getValue();
        }
        return arr;
    }


}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        MaxHeap res = new MaxHeap(k, points);
        return res.convertToArray();
    }
}
