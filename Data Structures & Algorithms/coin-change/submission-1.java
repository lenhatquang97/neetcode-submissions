class Solution {
    public int coinChange(int[] coins, int amount) {
       /*
       1,5,10 - note = 12
       f(1) = 1
       f(2) = f(2-1) + 1 = 2
       f(3) = f(3-1) + 1 = 3
       f(4) = 4  
       f(5) = f(4) + 1, f(5 - 5) + 1
       */
       if (amount == 0) return 0;
       int[] res = new int[amount + 1];
       Arrays.fill(res, amount + 1);
       res[0] = 0;

       for (int i = 1; i<=amount; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (i - coins[j] < 0) continue;
            res[i] = Math.min(res[i], res[i - coins[j]] + 1);
        }
       }
       return res[amount] > amount ? -1 : res[amount];
    }
}
