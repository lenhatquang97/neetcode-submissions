class Solution {
    public double powWithPositive(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            return powWithPositive(x, n / 2) * powWithPositive(x, n / 2);
        } else {
            return powWithPositive(x, n / 2) * powWithPositive(x, n / 2 + 1);
        }
    }
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        boolean isMinus = n < 0;
        double ans = powWithPositive(x, isMinus ? -n : n);
        return isMinus ? 1.0 / ans : ans;
    }
}
