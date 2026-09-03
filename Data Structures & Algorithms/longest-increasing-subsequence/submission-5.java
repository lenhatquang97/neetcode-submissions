class Solution {
    private int[][] memo;
    public int eval(int[] nums, int current, int next) {
        int finalAns = 0;
        if (next >= nums.length) return 0;
        if (memo[current + 1][next] != -1)
            return memo[current + 1][next];
        if (current == -1 || nums[next] > nums[current]) {
            finalAns = Math.max(finalAns, 1 + eval(nums, next, next + 1));
        }
        finalAns = Math.max(finalAns, eval(nums, current, next + 1));
        memo[current + 1][next] = finalAns;
        return finalAns;
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        memo = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {
                memo[i][j] = -1;
            }
        }
        return eval(nums, -1, 0);
        
    }
}
