class Solution {
    public int countOneInNum(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            cnt += (bit == 1) ? 1 : 0;
        }
        return cnt;
    }
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOneInNum(i);
        }
        return res;
    }
}
