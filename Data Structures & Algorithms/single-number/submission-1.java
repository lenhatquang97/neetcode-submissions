class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
