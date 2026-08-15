class Solution {
    public ArrayList<List<Integer>> res = new ArrayList<>();
    public void backtrack(List<Integer> ls, int[] nums, int index, int curSum, int total) {
        if (curSum > total) return;
        if (curSum == total) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            ls.add(nums[i]);
            backtrack(ls, nums, i, curSum + nums[i], total);
            if (ls.size() > 0) ls.remove(ls.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(new ArrayList<>(), nums, 0, 0, target);
        return res;
    }
}
