class Solution {
    public int maxProduct(int[] nums) {
        /*
        f[i][j] 

        f[i][j] = nums[i] (i = j)
        f[i][j] = 1 (i > j)

        f[0][1] = nums[0] * f[1][1]
        f[0][2] = nums[0] * f[1][2]
        
        */

        int maxVal = Integer.MIN_VALUE;
        int[][] f = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    f[i][j] = nums[i];
                    maxVal = Math.max(maxVal, f[i][j]);
                } else if (i > j) {
                    f[i][j] = 1;
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= j) continue;
                f[i][j] = nums[i] * f[i+1][j];
                maxVal = Math.max(maxVal, f[i][j]);
            }
        }

        return maxVal;
    }
}
