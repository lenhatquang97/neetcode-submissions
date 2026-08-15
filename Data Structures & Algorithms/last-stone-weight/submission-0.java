class Solution {
    public Comparator<Integer> c = (a, b) -> b - a;
    public PriorityQueue<Integer> heap = new PriorityQueue<>(c);
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        for (int i = 0; i < stones.length; i++) {
            heap.add(stones[i]);
        }
        do {
            if (heap.size() == 1) {
                return heap.peek();
            }
            int a = heap.poll();
            int b = heap.poll();
            if (a != b) {
                heap.add(Math.abs(a - b));
            }
        } while (heap.size() > 0);
        return 0;
    }
}
