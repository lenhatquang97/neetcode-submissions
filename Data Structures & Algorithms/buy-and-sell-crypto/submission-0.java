class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxVal = 0;
        int left = 0;
        int right = 1;
        while (left < prices.length && right < prices.length) {
            if (left == right) {
                right++;
            } else if (prices[left] < prices[right]) {
                maxVal = Math.max(maxVal, prices[right] - prices[left]);
                right++;
            } else {
                left++;
            }
        }
        return maxVal;
    }
}
