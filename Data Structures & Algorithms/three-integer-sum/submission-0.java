class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        Arrays.sort(nums);
        // -4, -1, -1, 0, 1, 2
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    int key = nums[i] * 100 + nums[left] * 10 + nums[right];
                    if (!st.contains(key)) {
                        st.add(key);
                        ls.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ls;
    }
}
