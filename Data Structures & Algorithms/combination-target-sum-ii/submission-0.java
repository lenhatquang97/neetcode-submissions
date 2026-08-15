class Solution {
    public Set<List<Integer>> res = new HashSet<>();
    public void backtrack(List<Integer> ls, int[] nums, int index, int curSum, int total) {
        if (curSum > total) return;
        if (curSum == total) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            ls.add(nums[i]);
            backtrack(ls, nums, i + 1, curSum + nums[i], total);
            if (ls.size() > 0) ls.remove(ls.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, 0, 0, target);
        return new ArrayList<>(res);
    }
}
