class Solution {
    public int findMin(int[] nums) {
        // 3 1 2
        // 3 4 1 2
        // 1 2 3 4
        int left = 0;
        int right = nums.length - 1;
        int minVal = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
                minVal = Math.min(minVal, nums[mid]);
            } else {
                left = mid + 1;
                minVal = Math.min(minVal, nums[mid]);
            }
        }
        return minVal;
    }
}
