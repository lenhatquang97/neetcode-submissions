class Solution {
    int jumpStep = 100000;
    public int canJumpEval(int[] nums, int index, Map<Integer, Integer> memos) {
        if (memos.containsKey(index)) {
            return memos.get(index);
        }
        if (index >= nums.length) return 0;
        if (index == nums.length - 1) return 0;
        if (nums[index] == 0) return 100000;
        int maxStep = nums[index];
        for (int i = maxStep; i >= 1; i--) {
            jumpStep = Math.min(jumpStep, 1 + canJumpEval(nums, index + i, memos));
            memos.put(index, jumpStep);
        }
        return jumpStep;
    }
    public int jump(int[] nums) {
        Map<Integer, Integer> memos = new HashMap<>();
        return canJumpEval(nums, 0, memos);
    }
}
