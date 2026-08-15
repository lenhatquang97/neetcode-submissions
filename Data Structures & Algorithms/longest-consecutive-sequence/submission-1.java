class Solution {
    public int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        HashSet<Integer>whiteList = new HashSet<>();

        while(hashSet.size() > 0) {
            int start = -1000000000;
            int num = 0;
            for (Integer i: hashSet) {
                if (!hashSet.contains(i - 1)) {
                    start = i;
                    break;
                }
            }
            while (hashSet.contains(start)) {
                hashSet.remove(start);
                num++;
                start++;
            }
            maxSeq = Math.max(maxSeq, num);
        }
        return maxSeq;
    }
}
