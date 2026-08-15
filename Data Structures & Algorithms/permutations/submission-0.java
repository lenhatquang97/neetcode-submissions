class Solution {
    public ArrayList<List<Integer>> res = new ArrayList<>();
    public void backtrack(int[] nums, List<Integer> ls, Set<Integer> numSet) {
        if (ls.size() == nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(i)) {
                ls.add(nums[i]);
                numSet.add(i);
                backtrack(nums, ls, numSet);
                ls.remove(ls.size() - 1);
                numSet.remove(i);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return res;
        
    }
}
