class Solution {
    public int[] plusOne(int[] digits) {
        int remember = 0;
        for (int i = digits.length - 1; i>=0; i--) {
            int num = (i == digits.length - 1) ? digits[i] + 1 : digits[i] + remember;
            remember = num / 10;
            int finalDigit = num % 10;
            digits[i] = finalDigit;
        }
        if (remember == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                newArr[i] = digits[i - 1];
            }
            return newArr;
        }
        return digits;
    }
}
