class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] - cost[0] >= 0 ? 0 : -1;
        }
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }

        if (sumGas < sumCost) return -1;

        int[] f = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            int flag = i;
            int start = i;
            int move = (i + 1) % gas.length;
            f[start] = gas[start];
            do {
                if (f[start] < cost[start]) {
                    i = start;
                    f[start] = 0;
                    break;
                }
                f[move] = f[start] - cost[start] + gas[move];

                if (move == flag) {
                    return flag;
                } 
                start = move;
                move = (move + 1) % gas.length;
            } while (true);
        }
        return -1;
    }
}
