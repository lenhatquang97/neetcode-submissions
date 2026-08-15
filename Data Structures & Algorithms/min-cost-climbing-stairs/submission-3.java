class Solution {
    public int calculatePath(int[] cost, int start) {
        if (start >= cost.length) return 0;
        return cost[start] + Math.min(calculatePath(cost, start + 1), calculatePath(cost, start + 2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] minList = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            minList[i] = Integer.MAX_VALUE;
        }
        for (int i = cost.length - 1; i >= 0; i--) {
            if (i == cost.length - 1) {
                minList[i] = cost[i];
                continue;
            } 

            if (i + 1 < cost.length) {
                minList[i] = Math.min(cost[i] + minList[i + 1], minList[i]);
            } else {
                minList[i] = cost[i];
            }

            if (i + 2 < cost.length) {
                minList[i] = Math.min(cost[i] + minList[i + 2], minList[i]);
            } else {
                minList[i] = cost[i];
            }

        }
        return Math.min(minList[0], minList[1]);
    }
}
