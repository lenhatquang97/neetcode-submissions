class Solution {
    boolean jumpFlag = false;
    public boolean canJumpEval(int[] nums, int index, Map<Integer, Boolean> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index >= nums.length) return false;
        if (index == nums.length - 1) return true;
        if (nums[index] == 0) return false;
        int maxStep = nums[index];
        for (int i = maxStep; i >= 1; i--) {
            jumpFlag = jumpFlag || canJumpEval(nums, index + i, memo);
            memo.put(index, jumpFlag);
        }
        return jumpFlag;
    }
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return canJumpEval(nums, 0, memo);
    }
}
