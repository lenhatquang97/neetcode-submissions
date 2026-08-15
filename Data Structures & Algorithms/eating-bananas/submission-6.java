class Solution {
    public int maxOfPiles(int[] piles) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res = Math.max(res, piles[i]);
        }
        return res;
    }
    public int ceilOfPiles(int[] piles, int k) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += Math.ceil((double) piles[i] / k);
        }
        return res;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = maxOfPiles(piles);
        int res = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int tmp = ceilOfPiles(piles, mid);
            if (tmp <= h) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
