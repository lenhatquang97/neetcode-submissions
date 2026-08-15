class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[0];
                continue;
            } else if (i == 1) {
                dp[i] = Math.max(nums[i], nums[i-1]);
                continue;
            } else {
                dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
            }
        }
        return dp[nums.length - 1];
    }
}
