class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            arr.add(new ArrayList<>());
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[k];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer i: hm.keySet()) {
            arr.get(hm.get(i)).add(i);
        }
        for (int i = 10000; i >= 0; i--) {
            if (arr.get(i).size() != 0) {
                for (int j = 0; j < arr.get(i).size(); j++) {
                    if (index >= k) return res;
                    res[index] = arr.get(i).get(j);
                    index++;
                }
                if (index >= k) return res;
            }
        }
        return res;
        
    }
}
