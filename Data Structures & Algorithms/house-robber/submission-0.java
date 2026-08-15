class Solution {
    public int rob(int[] nums) {
        int finalAns = 0;
        if (nums.length == 1) return nums[0];
        int[] maxVal = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                maxVal[i] = nums[i];
            } else if (i == nums.length - 2) {
                maxVal[i] = Math.max(nums[i], maxVal[i+1]);
            } else {
                maxVal[i] = Math.max(nums[i] + maxVal[i + 2], maxVal[i + 1]);
            }
            finalAns = Math.max(finalAns, maxVal[i]);
        }

        return finalAns;

        /*
        2, 9, 8, 3, 6
        f(i) = max(nums(i) + max(nums(i+2)), f(i+1))
        f(n - 1) = k
        f(n - 2) = max(nums(n-2), k)

        m(f(4)) = f(4) + m(f(5))
        
        m(4) = 6
        m(3) = 3
        m(2) = 14
        m(1) = 9 + max(m3, m4) = 15
        m(0) = 2 + max(f(2)) = 
        */
        
    }
}
