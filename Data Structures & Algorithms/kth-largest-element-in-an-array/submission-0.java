class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        while (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
