class KthLargest {
    private ArrayList<Integer> heapArray = new ArrayList<>();
    private int kMax = -1;

    public KthLargest(int k, int[] nums) {
        kMax = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
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
        int tmp = heapArray.get(i);
        heapArray.set(i, heapArray.get(j));
        heapArray.set(j, tmp);
    }

    private void insert(int val) {
        heapArray.add(val);

        int i = heapArray.size() - 1;

        while (i != 0 &&
            heapArray.get(i) < heapArray.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void insertToTopK(int val) {
        if (heapArray.size() < kMax) {
            insert(val);
            return;
        }

        if (val > heapArray.get(0)) {
            heapArray.set(0, val);
            minHeapify(0);
        }
    }

    public int add(int val) {
        insertToTopK(val);
        return heapArray.get(0);
    }


    private void minHeapify(int key) {
        int l = left(key);
        int r = right(key);

        int smallest = key;
        if (l < heapArray.size() && heapArray.get(l) < heapArray.get(smallest)) {
            smallest = l;
        }
        if (r < heapArray.size() && heapArray.get(r) < heapArray.get(smallest)) {
            smallest = r;
        }

        if (smallest != key) {
            swap(key, smallest);
            minHeapify(smallest);
        }
    }
}
