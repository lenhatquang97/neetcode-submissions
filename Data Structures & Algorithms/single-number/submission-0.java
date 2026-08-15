class Solution {
    public int singleNumber(int[] nums) {
        int firstValue = nums[0];
        for(int i = 1; i < nums.length; i++) {
            firstValue = firstValue ^ nums[i];
        }
        return firstValue;
    }
}
