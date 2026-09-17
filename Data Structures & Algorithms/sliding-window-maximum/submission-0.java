class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        res.add(maxHeap.peek());
        
        int start = 1;
        int end = k;

        do {
            if (end == nums.length) 
                return res.stream().mapToInt(Integer::intValue).toArray();
            maxHeap.remove(nums[start - 1]);
            maxHeap.add(nums[end]);
            res.add(maxHeap.peek());
            start++;
            end++;
        } while (end < nums.length);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
