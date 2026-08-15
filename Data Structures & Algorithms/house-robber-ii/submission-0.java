class Solution {
    public void robV1(int[] nums, int[] maxVal) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                maxVal[i] = nums[i];
            } else if (i == nums.length - 2) {
                maxVal[i] = Math.max(nums[i], maxVal[i + 1]);
            } else {
                maxVal[i] = Math.max(nums[i] + maxVal[i + 2], maxVal[i + 1]);
            }
        }
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] leftSide = new int[nums.length - 1];
        int[] maxLeftSide = new int[nums.length - 1];
        
        int[] rightSide = new int[nums.length - 1];
        int[] maxRightSide = new int[nums.length - 1];

        for (int i = 0; i <= nums.length - 2; i++) {
            leftSide[i] = nums[i];
        }

        for (int i = 1; i <= nums.length - 1; i++) {
            rightSide[i - 1] = nums[i];
        }

        robV1(leftSide, maxLeftSide);
        robV1(rightSide, maxRightSide);

        int maxVal = 0;
        for (int i = 0; i < maxLeftSide.length; i++) {
            maxVal = Math.max(maxVal, maxLeftSide[i]);
        }

        for (int i = 0; i < maxRightSide.length; i++) {
            maxVal = Math.max(maxVal, maxRightSide[i]);
        }
        return maxVal;

    }
}
