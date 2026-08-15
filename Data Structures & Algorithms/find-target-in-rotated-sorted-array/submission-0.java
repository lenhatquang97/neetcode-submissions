class Solution {
    public int bs(int[] nums, int left, int right, int target){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        int res1 = bs(nums, 0, l, target);
        int res2 = bs(nums, l, nums.length - 1, target);
        return (res1 != -1 || res2 != -1) ? Math.max(res1, res2) : -1;
    }
}
