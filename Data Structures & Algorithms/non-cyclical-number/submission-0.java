class Solution {
    public int calculateSquaresOfDigits(int n) {
        int res = 0;
        int tempNumber = n;
        do {
            int digit = tempNumber % 10;
            res += digit * digit;
            tempNumber = tempNumber / 10;
        } while (tempNumber > 0);
        return res;
    }
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> s = new HashSet<>();
        int tmp = n;

        while(true) {
            tmp = calculateSquaresOfDigits(tmp);
            if (tmp == 1) {
                return true;
            } else if (s.contains(tmp)) {
                return false;
            } else {
                s.add(tmp);
            }
        }
    }
}
