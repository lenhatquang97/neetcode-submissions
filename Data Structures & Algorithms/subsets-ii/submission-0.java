class Solution {
    public Set<List<Integer>> res = new HashSet<>();
    public void backtrack(List<Integer> ls, int[] nums, int index, int total) {
        if (ls.size() == total) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            ls.add(nums[i]);
            backtrack(ls, nums, i + 1, total);
            if (ls.size() > 0) ls.remove(ls.size() - 1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for (int total = 1; total <= nums.length; total++) {
            backtrack(new ArrayList<>(), nums, 0, total);
        }
        return new ArrayList<>(res);
    }
}
