class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target-nums[i];
            if (hm.containsKey(num) && i != hm.get(num)) {
                return new int[]{i, hm.get(num)};
            }
        }
        return new int[]{-1, -1};
    }
}

